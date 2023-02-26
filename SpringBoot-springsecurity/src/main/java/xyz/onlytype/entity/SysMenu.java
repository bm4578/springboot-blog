package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单表

 * @TableName sys_menu
 */
@ApiModel(description = "菜单表")
@TableName(value ="sys_menu")
@Data
public class SysMenu implements Serializable{
    /**
     * 菜单id
     */
    @ApiModelProperty("菜单id")
    @TableId
    private Long menuId;

    /**
     * code
     */
    @ApiModelProperty("code")
    private String menuCode;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String menuIcon;

    /**
     * 菜单URL
     */
    @ApiModelProperty("菜单URL")
    private String menuUrl;

    /**
     * 父级code
     */
    @ApiModelProperty("父级code")
    private String parentCode;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date updateTime;

    /**
     * 子菜单
     */
    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<>();

    //菜单的实体类中加addChild方法
    public void addChild(SysMenu menu) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(menu);
    }


    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}