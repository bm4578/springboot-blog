package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.onlytype.entity.SysRole;
import xyz.onlytype.mapper.SysRoleMapper;
import xyz.onlytype.service.SysRoleService;
import xyz.onlytype.vo.SysUserRoleVO;

import java.util.List;

/**
 * @author 白也
 * @description 针对表【sys_role(角色表)】的数据库操作Service实现
 * @createDate 2023-02-22 10:25:39
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询角色信息
     *
     * @return 角色id、角色名称
     */
    @Override
    public List<SysRole> selectAllRoleList() {
        return sysRoleMapper.selectList(null);
    }

    /**
     * 新增权限
     *
     * @return true/false
     */
    @Override
    public boolean addRole(SysRole sysRole) {
        SysRole role = new SysRole();
        role.setRoleName(sysRole.getRoleName());
        role.setRoleKey(sysRole.getRoleKey());
        return sysRoleMapper.insert(role) > 0;
    }

    /**
     * 查询所用户的角色信息
     *
     * @return 用户角色列表
     */
    @Override
    public List<SysUserRoleVO> selectUserRole() {
        return sysRoleMapper.selectUserRole();
    }
}




