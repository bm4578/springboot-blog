package xyz.onlytype.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysPage;

/**
* @author 白也
* @description 针对表【sys_page(页面基本信息
)】的数据库操作Service
* @createDate 2023-02-23 16:33:20
*/
public interface SysPageService extends IService<SysPage> {
    /**
     * 查询首页菜单
     * @return
     */
    PageVO<SysPage> selectPage(int pageNum, int pageSize);
    /**
     * 新增菜单
     * @param sysPage 新增菜单
     * @return true/false
     */
    boolean addMenu(SysPage sysPage);

    /**
     * 删除菜单
     * @param menuId 菜单Id
     * @return true/false
     */
    boolean deleteMenu(Long menuId);

    /**
     * 修改菜单
     * @param sysPage 菜单信息
     * @return true/false
     */
    boolean updateMenu(SysPage sysPage);
}
