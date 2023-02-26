package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表
 * @TableName sys_user
 */
@ApiModel(description = "用户表")
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * 用户 ID
     */
    @ApiModelProperty("用户 ID")
    @TableId
    private Long userId;

    /**
     * 系统登录名
     */
    @ApiModelProperty("系统登录名")
    private String username;

    /**
     * 登录密码，加密存储, admin/1234
     */
    @ApiModelProperty("登录密码，加密存储, admin/1234")
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String isEmail;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String isImg;

    /**
     * 逻辑删除(0可用，1 删除用户)
     */
    @ApiModelProperty("逻辑删除(0可用，1 删除用户)")
    private Integer isEnabled;

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

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}