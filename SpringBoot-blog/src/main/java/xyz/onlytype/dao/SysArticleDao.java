package xyz.onlytype.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.onlytype.entity.SysArticle;

/**
 * 文章标题(SysArticle)表数据库访问层
 *
 * @author 白也
 * @since 2023-02-20 10:47:27
 */
@Mapper
public interface SysArticleDao extends BaseMapper<SysArticle> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysArticle> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysArticle> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysArticle> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SysArticle> entities);

}

