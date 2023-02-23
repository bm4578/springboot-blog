package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色菜单表


 * @TableName sys_role_menu
 */
@ApiModel(description = "角色菜单表")
@TableName(value ="sys_role_menu")
@Data
public class SysRoleMenu implements Serializable {
    /**
     * 角色菜单id
     */
    @ApiModelProperty("角色菜单id")
    @TableId
    private Long roleMenuId;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Long roleId;

    /**
     * 菜单id
     */
    @ApiModelProperty("菜单id")
    private Long menuId;

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

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}