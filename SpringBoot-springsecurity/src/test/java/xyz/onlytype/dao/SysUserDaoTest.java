package xyz.onlytype.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.onlytype.vo.UserRoleVo;

import java.util.List;

/**
 * @author 白也
 * @title
 * @date 2023/1/28 4:18 下午
 */
@SpringBootTest
class SysUserDaoTest {
    @Autowired
    private SysUserDao sysUserDao;
    @Test
    public void Test(){
        List<UserRoleVo> rolesByUser = sysUserDao.findRolesByUserId("420029352e7efb783f9396feb1a5d5e2");
        System.out.println(rolesByUser);
    }

    @Test
    void findByUserinfo() {

    }
}