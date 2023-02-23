package xyz.onlytype.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 白也
 * @title 封装用户权限信息
 * @date 2023/1/28 14:57
 */
@ApiModel(description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleVo implements Serializable {
    @ApiModelProperty(hidden = true)
    private static final long serialVersionUID = 1L;
    //用户id
    @ApiModelProperty("用户id")
    private String userId;
    //系统登录名
    @ApiModelProperty("系统登录名")
    private String username;
    //角色id
    @ApiModelProperty("角色id")
    private String roleId;
    //角色名称
    @ApiModelProperty("角色名称")
    private String roleName;

}
