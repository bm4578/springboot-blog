package xyz.onlytype.mapper;

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
public interface SysUserMapper extends BaseMapper<SysUser> {


    /**
     * 根据用户Id查询角色
     * @param userId
     * @return
     */
    List<UserRoleVo> findRolesByUserId(String userId);


    /**
     * 角色查询
     * @param userId 用户id
     * @return
     */
    List<String> findRoleByUserId(Long userId);


    /**
     * 用户信息查询
     * @param username
     * @return
     */
    UserInfoVo findByUserinfo(String username);


    /**
     * 权限菜单查询
     * @param roleKey
     * @return
     */
    List<SysMenu> finMenuByUserRoles(String roleKey);

    /**
     * 恢复已经删除的用户
     * @param userId 用户id
     * @return 0/1
     */
    Integer recoverUser(String userId);


}

