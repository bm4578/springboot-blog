package xyz.onlytype.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.onlytype.entity.SysRole;
import xyz.onlytype.vo.SysUserRoleVO;

import java.util.List;

/**
 * @author 白也
 * @description 针对表【sys_role(角色表)】的数据库操作Mapper
 * @createDate 2023-02-22 10:25:39
 * @Entity xyz.onlytype.entity.SysRole
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查询所用户的角色信息
     * @return
     */
    List<SysUserRoleVO> selectUserRole();
}




