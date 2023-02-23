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
 * 用户角色表

 * @TableName sys_user_role
 */
@ApiModel(description = "用户角色表")
@TableName(value ="sys_user_role")
@Data
public class SysUserRole implements Serializable {
    /**
     * 用户角色id
     */
    @ApiModelProperty("用户角色id")
    @TableId
    private String userRoleId;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private String roleId;

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