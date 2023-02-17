package xyz.onlytype.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.entity.SysUser;
import xyz.onlytype.vo.UserInfoVo;
import xyz.onlytype.vo.UserRoleVo;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author 白也
 * @since 2023-01-28 11:23:37
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

    //根据用户Id查询角色
    List<UserRoleVo> findRolesByUserId(String userId);

    //角色查询
    List<String> findRoleByUserId(String userId);

    //用户信息查询
    UserInfoVo findByUserinfo(String username);

    //权限菜单查询
    List<SysMenu> finMenuByUserRoles(String roleKey);


}

