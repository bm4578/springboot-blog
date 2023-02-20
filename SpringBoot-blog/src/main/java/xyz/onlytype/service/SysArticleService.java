package xyz.onlytype.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysArticle;

/**
 * 文章标题(SysArticle)表服务接口
 *
 * @author 白也
 * @since 2023-02-20 10:47:27
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

