package xyz.onlytype.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.onlytype.entity.SysMenu;

import java.io.Serializable;
import java.util.List;

/**
 * @author 白也
 * @title 用户所有信息
 * @date 2023/2/11 9:54 下午
 */
@ApiModel(description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo implements Serializable {
    @ApiModelProperty(hidden = true)
    private static final long serialVersionUID = 1L;
    //用户名称
    @ApiModelProperty("用户名称")
    private String username;
    //用户邮箱
    @ApiModelProperty("用户邮箱")
    private String isEmail;
    //头像
    @ApiModelProperty("头像")
    private String isImg;
    //用户菜单
    @ApiModelProperty("用户菜单")
    @TableField(exist = false)
    private List<SysMenu> sysMenus;
}
