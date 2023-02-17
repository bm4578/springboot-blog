package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.dao.SysMenuDao;
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
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> selectAllMenus() {
        List<SysMenu> sysMenus = sysMenuDao.selectList(null);
        //树状结构转化
        List<SysMenu> menuTree = buildMenusTree(sysMenus);
        return menuTree;
    }

    private List<SysMenu> buildMenusTree(List<SysMenu> sysMenus) {
        List<SysMenu> finalMenus = new ArrayList<>();
        for (SysMenu sysMenu : sysMenus) {
            for (SysMenu menu : sysMenus) {
                if (sysMenu.getMenuCode().equals(menu.getParentCode())){
                    sysMenu.getChildNode().add(menu);
                }
            }
            //提取父节点
            if (sysMenu.getParentCode() == null) {
                finalMenus.add(sysMenu);
            }
        }
        return finalMenus;
    }
}

