package xyz.onlytype.mapper;

import xyz.onlytype.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 白也
* @description 针对表【sys_menu(菜单表
)】的数据库操作Mapper
* @createDate 2023-02-23 10:27:34
* @Entity xyz.onlytype.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}




