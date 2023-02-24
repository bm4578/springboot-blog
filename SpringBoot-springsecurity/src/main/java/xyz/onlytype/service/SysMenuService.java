package xyz.onlytype.service;

import xyz.onlytype.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 白也
* @description 针对表【sys_menu(菜单表
)】的数据库操作Service
* @createDate 2023-02-23 10:27:34
*/
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询所有菜单
     * @return
     */
    List<SysMenu> seleteAllMenus();

    /**
     * 新增菜单
     * @param sysMenu 新增菜单
     * @return true/false
     */
    boolean addMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param menuId 菜单Id
     * @return true/false
     */
    boolean deleteMenu(Long menuId);

    /**
     * 修改菜单
     * @param sysMenu 菜单信息
     * @return true/false
     */
    boolean updateMenu(SysMenu sysMenu);
}
