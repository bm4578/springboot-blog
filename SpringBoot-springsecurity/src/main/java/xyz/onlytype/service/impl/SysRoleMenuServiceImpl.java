package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.entity.SysRoleMenu;
import xyz.onlytype.service.SysRoleMenuService;
import xyz.onlytype.mapper.SysRoleMenuMapper;
import org.springframework.stereotype.Service;

/**
 * @author 白也
 * @description 针对表【sys_role_menu(角色菜单表
 * <p>
 * )】的数据库操作Service实现
 * @createDate 2023-02-23 09:30:18
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>
        implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 新增用户菜单
     *
     * @param sysRoleMenu 用户信息
     * @return true/false
     */
    @Override
    public boolean addUserMenu(SysRoleMenu sysRoleMenu) {
        SysRoleMenu menu = new SysRoleMenu();
        menu.setRoleId(sysRoleMenu.getRoleId());
        menu.setMenuId(sysRoleMenu.getMenuId());
        return sysRoleMenuMapper.insert(menu) > 0;
    }

    /**
     * 删除用户菜单
     * @param roleMenuId 用户id
     * @return true/false
     */
    @Override
    public boolean deleteUserMenu(String roleMenuId) {
        return sysRoleMenuMapper.deleteById(roleMenuId) > 0;
    }
}




