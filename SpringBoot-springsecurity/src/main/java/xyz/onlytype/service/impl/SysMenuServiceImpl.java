package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.service.SysMenuService;
import xyz.onlytype.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author 白也
* @description 针对表【sys_menu(菜单表
)】的数据库操作Service实现
* @createDate 2023-02-23 10:27:34
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{
    @Autowired
    private SysMenuMapper sysMenuMapper;


    /**
     * 新增菜单
     *
     * @param sysMenu 新增菜单
     * @return true/false
     */
    @Override
    public boolean addMenu(SysMenu sysMenu) {
        SysMenu menu = new SysMenu();
        menu.setMenuName(sysMenu.getMenuName());
        menu.setMenuUrl(sysMenu.getMenuUrl());
        menu.setMenuIcon(sysMenu.getMenuIcon());
        menu.setMenuCode(sysMenu.getMenuCode());
        menu.setParentCode(sysMenu.getParentCode());
        return sysMenuMapper.insert(menu) > 0;
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单Id
     * @return
     */
    @Override
    public boolean deleteMenu(String menuId) {
        return sysMenuMapper.deleteById(menuId) > 0;
    }

    /**
     * 修改菜单
     *
     * @param sysMenu 菜单信息
     * @return true/false
     */
    @Override
    public boolean updateMenu(SysMenu sysMenu) {
        SysMenu menu = new SysMenu();
        menu.setMenuName(sysMenu.getMenuName());
        menu.setMenuIcon(sysMenu.getMenuIcon());
        menu.setMenuIcon(sysMenu.getMenuIcon());
        menu.setMenuCode(sysMenu.getMenuCode());
        menu.setParentCode(sysMenu.getParentCode());
        return sysMenuMapper.updateById(sysMenu) > 0;
    }
}




