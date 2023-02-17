package xyz.onlytype.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.onlytype.entity.SysMenu;

/**
 * 菜单表
(SysMenu)表数据库访问层
 *
 * @author 白也
 * @since 2023-02-12 20:44:30
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {

}

