package xyz.onlytype.service;

import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 白也
* @description 针对表【sys_article(文章标题)】的数据库操作Service
* @createDate 2023-02-23 11:45:28
*/
public interface SysArticleService extends IService<SysArticle> {
    /**
     * 分页查询文章列表
     * @param pageNum 分页条数
     * @param pageSize 分页大小
     * @return
     */
    PageVO<SysArticle> pageList(int pageNum, int pageSize);

    /**
     * 添加文章
     * @param sysArticle 添加文章
     * @return
     */
    Boolean addArticle(SysArticle sysArticle);

    /**
     * 文章删除
     * @param articleId 文章id
     * @return
     */
    Boolean deleteArticle(String articleId);

    /**
     * 修改文章
     * @param sysArticle 文章主体
     * @return
     */
    Boolean updateArticle(SysArticle sysArticle);
}
