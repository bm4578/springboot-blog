package xyz.onlytype.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.entity.SysRole;
import xyz.onlytype.vo.SysUserRoleVO;

import java.util.List;

/**
* @author 白也
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2023-02-22 10:25:39
*/
public interface SysRoleService extends IService<SysRole> {

    /**
     * 查询角色信息
     * @return 角色信息
     */
    List<SysRole> selectAllRoleList();

    /**
     * 新增权限
     * @return true/false
     */
    boolean addRole(SysRole sysRole);

    /**
     * 查询所用户的角色信息
     * @return 用户角色列表
     */
    List<SysUserRoleVO> selectUserRole();

}
