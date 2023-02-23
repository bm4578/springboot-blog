package xyz.onlytype.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(SysUser)表实体类
 *
 * @author 白也
 * @since 2023-01-28 11:23:37
 */
@ApiModel(description = "用户表(SysUser)表实体类")
@SuppressWarnings("serial")
@Data
public class SysUser extends Model<SysUser> implements Serializable{
    //用户 ID
    @ApiModelProperty("用户 ID")
    @TableId(type = IdType.ASSIGN_UUID)
    private String userId;
    //系统登录名
    @ApiModelProperty("系统登录名")
    private String username;
    //登录密码，加密存储, admin/1234
    @ApiModelProperty("登录密码，加密存储, admin/1234")
    private String password;
    //邮箱
    @ApiModelProperty("邮箱")
    private String isEmail;
    //头像
    @ApiModelProperty("头像")
    private String isImg;
    //逻辑删除
    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer isEnabled;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createTime = new Date();
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime = new Date();
    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
    }

