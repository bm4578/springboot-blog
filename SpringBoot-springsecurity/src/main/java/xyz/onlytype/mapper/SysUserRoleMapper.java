package xyz.onlytype.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.onlytype.entity.SysUserRole;

/**
* @author 白也
* @description 针对表【sys_user_role(用户角色表
)】的数据库操作Mapper
* @createDate 2023-02-22 09:55:03
* @Entity xyz.onlytype.entity.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}




