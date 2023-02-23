package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.mapper.SysMenuMapper;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单表
 * (SysMenu)表服务实现类
 *
 * @author 白也
 * @since 2023-02-12 20:44:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
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

