package xyz.onlytype.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 白也
 * @title
 * @date 2023/2/22 10:22 上午
 */

@ApiModel(description = "用户角色Vo")
@Data
public class SysUserRoleVO implements Serializable {

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String username;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 唯一key
     */
    @ApiModelProperty("唯一key")
    private String roleKey;

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
