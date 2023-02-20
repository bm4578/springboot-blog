package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.dao.SysArticleDao;
import xyz.onlytype.entity.SysArticle;
import xyz.onlytype.service.SysArticleService;
import org.springframework.stereotype.Service;

/**
 * 文章标题(SysArticle)表服务实现类
 *
 * @author 白也
 * @since 2023-02-20 10:47:27
 */
@Service("sysArticleService")
public class SysArticleServiceImpl extends ServiceImpl<SysArticleDao, SysArticle> implements SysArticleService {
    @Autowired
    private SysArticleDao sysArticleDao;
    /**
     * 分页查询文章列表
     * @param pageNum 分页条数
     * @param pageSize 分页大小
     * @return
     */

    @Override
    public PageVO<SysArticle> pageList(int pageNum, int pageSize) {
        return PageVO.pageList(sysArticleDao.selectPage(new Page<>(pageNum,pageSize),null));
    }

    /**
     * 添加文章
     *
     * @param sysArticle 添加文章
     * @return
     */
    @Override
    public Boolean addArticle(SysArticle sysArticle) {
        SysArticle article = new SysArticle();
        article.setArticleId(sysArticle.getArticleId());
        article.setUid(sysArticle.getUid());
        article.setArticleTitle(sysArticle.getArticleTitle());
        article.setArticleList(sysArticle.getArticleList());
        article.setArticleType(sysArticle.getArticleType());
        article.setArticleCreate(sysArticle.getArticleCreate());
        article.setArticleUpdate(sysArticle.getArticleUpdate());
        return sysArticleDao.insert(article) > 0;
    }

    /**
     * 文章删除
     *
     * @param articleId 文章id
     * @return
     */
    @Override
    public Boolean deleteArticle(String articleId) {
        return sysArticleDao.deleteById(articleId) >0 ;
    }

    /**
     * 修改文章
     *
     * @param sysArticle 文章主体
     * @return
     */
    @Override
    public Boolean updateArticle(SysArticle sysArticle) {
        SysArticle article = new SysArticle();
        article.setArticleId(sysArticle.getArticleId());
        article.setUid(sysArticle.getUid());
        article.setArticleTitle(sysArticle.getArticleTitle());
        article.setArticleList(sysArticle.getArticleList());
        article.setArticleType(sysArticle.getArticleType());
        article.setArticleCreate(sysArticle.getArticleCreate());
        article.setArticleUpdate(sysArticle.getArticleUpdate());
        return sysArticleDao.updateById(article) > 0;
    }
}

