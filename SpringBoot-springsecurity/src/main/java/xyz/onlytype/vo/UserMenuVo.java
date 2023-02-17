package xyz.onlytype.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import xyz.onlytype.entity.SysMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 白也
 * @title 返回菜单对象
 * @date 2023/2/14 9:26 上午
 */

@Data
public class UserMenuVo {
    //菜单id
    private String menuId;
    //菜单名称
    private String menuName;
    //菜单图标
    private String menuIcon;
    //菜单URL
    private String menuUrl;
    //code
    private String menuCode;
    //父级code
    private String parentCode;
    //子级菜单
    @TableField(exist = false)
    private List<UserMenuVo> childNode = new ArrayList<>();
}
