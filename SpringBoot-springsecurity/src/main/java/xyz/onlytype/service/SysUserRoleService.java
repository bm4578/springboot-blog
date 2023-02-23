package xyz.onlytype.service;

import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.vo.SysUserRoleVO;

/**
* @author 白也
 * 新增用户角色
* @description 针对表【sys_user_role(用户角色表
)】的数据库操作Service
* @createDate 2023-02-22 09:55:03
*/
public interface SysUserRoleService extends IService<SysUserRole> {
    /**
     * 新增用户角色
     * @return true/false
     */
    boolean addUserRole(SysUserRole userRole);

    /**
     * 删除用户角色
     * @param userRoleId 用户id
     * @return true/false
     */
    boolean deleteUserRole(String userRoleId);
}
