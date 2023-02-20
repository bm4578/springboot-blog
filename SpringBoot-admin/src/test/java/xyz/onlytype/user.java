package xyz.onlytype;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.dao.SysArticleDao;
import xyz.onlytype.dao.SysUserDao;
import xyz.onlytype.entity.SysArticle;
import xyz.onlytype.entity.SysUser;
import xyz.onlytype.service.SysArticleService;
import xyz.onlytype.service.SysMenuService;
import xyz.onlytype.service.SysUserService;

import java.util.List;

/**
 * @author 白也
 * @title
 * @date 2023/2/20 3:35 下午
 */
@SpringBootTest
public class user {
    @Autowired
    private SysArticleService articleService;
    @Autowired
    SysUserDao userDao;

    @Autowired
    private SysUserService service;

    @Test
    void test01() {
        PageVO<SysArticle> sysArticlePageVO = articleService.pageList(1, 2);
        System.out.println(sysArticlePageVO);
    }
    @Test
    void test02(){
        LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysUserLambdaQueryWrapper.eq(SysUser::getUsername,"test");
        List<SysUser> users = userDao.selectList(sysUserLambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void deleteUser(){
        System.out.println(service.recoverUser("420029352e7efb783f9396feb1a5d5e2"));
    }

}
