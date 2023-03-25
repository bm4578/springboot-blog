package xyz.onlytype.mapper;

import xyz.onlytype.entity.SysArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 白也
* @description 针对表【sys_article(文章标题)】的数据库操作Mapper
* @createDate 2023-02-23 11:45:28
* @Entity xyz.onlytype.entity.SysArticle
*/
@Mapper
public interface SysArticleMapper extends BaseMapper<SysArticle> {

}




