package xyz.onlytype.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.onlytype.vo.SysUserRoleVO;

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




