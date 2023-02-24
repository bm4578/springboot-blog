package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单表

 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class SysMenu implements Serializable{
    /**
     * 菜单id
     */
    @TableId
    private Long menuId;

    /**
     * code
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * 父级code
     */
    private String parentCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 子菜单
     */
    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<SysMenu>();

    //菜单的实体类中加addChild方法
    public void addChild(SysMenu menu) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(menu);
    }


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}