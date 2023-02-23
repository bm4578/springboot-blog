package xyz.onlytype.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.entity.SysRoleMenu;
import xyz.onlytype.entity.SysUserRole;

/**
* @author 白也
* @description 针对表【sys_role_menu(角色菜单表

)】的数据库操作Service
* @createDate 2023-02-23 09:30:18
*/
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 新增用户菜单
     * @param sysRoleMenu 用户信息
     * @return true/false
     */
    boolean addUserMenu(SysRoleMenu sysRoleMenu);

    /**
     * 删除用户菜单
     * @param roleMenuId 用户id
     * @return true/false
     */
    boolean deleteUserMenu(String roleMenuId);
}
