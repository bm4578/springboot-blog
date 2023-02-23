package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysPage;
import xyz.onlytype.service.SysPageService;
import xyz.onlytype.mapper.SysPageMapper;
import org.springframework.stereotype.Service;

/**
 * @author 白也
 * @description 针对表【sys_page(页面基本信息
 * )】的数据库操作Service实现
 * @createDate 2023-02-23 16:33:20
 */
@Service
public class SysPageServiceImpl extends ServiceImpl<SysPageMapper, SysPage>
        implements SysPageService {
    @Autowired
    private SysPageMapper sysPageMapper;


    /**
     * 查询首页菜单
     *
     * @return
     */
    @Override
    public PageVO<SysPage> selectPage(int pageNum, int pageSize) {
        return PageVO.pageList(sysPageMapper.selectPage(new Page<>(pageNum, pageSize), null));
    }

    /**
     * 新增菜单
     *
     * @param sysPage 新增菜单
     * @return true/false
     */
    @Override
    public boolean addMenu(SysPage sysPage) {
        SysPage page = new SysPage();
        page.setMenuName(sysPage.getMenuName());
        page.setMenuUrl(sysPage.getMenuUrl());
        page.setMenuIcon(sysPage.getMenuIcon());
        page.setMenuType(sysPage.getMenuType());
        //不需要传入menuCode，自动使用雪花算法生成
        page.setMenuCode(String.valueOf(IdWorker.getId()));
        return sysPageMapper.insert(page) > 0;
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单Id
     * @return true/false
     */
    @Override
    public boolean deleteMenu(String menuId) {
        return sysPageMapper.deleteById(menuId) > 0;
    }

    /**
     * 修改菜单
     *
     * @param sysPage 菜单信息
     * @return true/false
     */
    @Override
    public boolean updateMenu(SysPage sysPage) {
        SysPage page = new SysPage();
        page.setMenuName(sysPage.getMenuName());
        page.setMenuUrl(sysPage.getMenuUrl());
        page.setMenuIcon(sysPage.getMenuIcon());
        page.setMenuType(sysPage.getMenuType());
        return sysPageMapper.updateById(page) > 0;
    }
}




