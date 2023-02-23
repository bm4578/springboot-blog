package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表

 * @TableName sys_menu
 */
@ApiModel(description = "菜单表")
@TableName(value ="sys_menu")
@Data
public class SysMenu implements Serializable {
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
    @TableId
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
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * 子菜单
     */
    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<SysMenu> childNode;

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}