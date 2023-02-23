package xyz.onlytype.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 白也
 * @title 返回菜单对象
 * @date 2023/2/14 9:26 上午
 */

@ApiModel(description = "")
@Data
public class UserMenuVo {
    //菜单id
    @ApiModelProperty("菜单id")
    private String menuId;
    //菜单名称
    @ApiModelProperty("菜单名称")
    private String menuName;
    //菜单图标
    @ApiModelProperty("菜单图标")
    private String menuIcon;
    //菜单URL
    @ApiModelProperty("菜单URL")
    private String menuUrl;
    //code
    @ApiModelProperty("code")
    private String menuCode;
    //父级code
    @ApiModelProperty("父级code")
    private String parentCode;
    //子级菜单
    @ApiModelProperty("子级菜单")
    @TableField(exist = false)
    private List<UserMenuVo> childNode = new ArrayList<>();
}
