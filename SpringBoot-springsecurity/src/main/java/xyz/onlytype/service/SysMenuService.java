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

    List<SysMenu> selectAllMenus();

}

