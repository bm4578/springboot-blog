package xyz.onlytype.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.vo.UserMenuVo;

import java.util.List;

/**
 * 菜单表
(SysMenu)表服务接口
 *
 * @author 白也
 * @since 2023-02-12 20:44:31
 */
public interface SysMenuService extends IService<SysMenu> {


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
    boolean deleteMenu(String menuId);

    /**
     * 修改菜单
     * @param sysMenu 菜单信息
     * @return true/false
     */
    boolean updateMenu(SysMenu sysMenu);


}

