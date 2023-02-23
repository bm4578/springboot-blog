package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysUserRole;
import xyz.onlytype.service.SysUserRoleService;
import xyz.onlytype.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;
import xyz.onlytype.vo.SysUserRoleVO;

/**
 * @author 白也
 * @description 针对表【sys_user_role(用户角色表
 * )】的数据库操作Service实现
 * @createDate 2023-02-22 09:55:03
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
        implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 新增用户角色
     *
     * @param userRole
     * @return true/false
     */
    @Override
    public boolean addUserRole(SysUserRole userRole) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(userRole.getUserId());
        sysUserRole.setRoleId(userRole.getRoleId());
        return sysUserRoleMapper.insert(sysUserRole) > 0;
    }

    /**
     * 删除用户角色
     *
     * @param userRoleId 用户id
     * @return true/false
     */
    @Override
    public boolean deleteUserRole(String userRoleId) {
        return sysUserRoleMapper.deleteById(userRoleId) > 0;
    }
}




