package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.service.SysMenuService;
import xyz.onlytype.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;
import xyz.onlytype.utils.SysMenuTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 白也
* @description 针对表【sys_menu(菜单表
)】的数据库操作Service实现
* @createDate 2023-02-23 10:27:34
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;


    /**
     * 查询所有菜单
     *
     * @return
     */
    @Override
    public List<SysMenu> seleteAllMenus() {
        //所有节点
        ArrayList<SysMenu> menuArrayList = new ArrayList<>();
        List<SysMenu> allList = sysMenuMapper.selectList(null);
        //list转Tree
        SysMenuTree.treeUtils(menuArrayList,allList);
        return menuArrayList;
    }

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

        if (StringUtils.isEmpty(sysMenu.getParentCode())){
            //父菜单 为空时，默认使用雪花算法生成子id---->一级菜单
            menu.setMenuCode(String.valueOf(IdWorker.getId()));
        }else {
            //不为空时，传入用户设置的父id----->二级菜单
            menu.setParentCode(sysMenu.getParentCode());
            menu.setMenuCode(String.valueOf(IdWorker.getId()));
        }
        return sysMenuMapper.insert(menu) > 0;
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单Id
     * @return
     */
    @Override
    public boolean deleteMenu(Long menuId) {
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




