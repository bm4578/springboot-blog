package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.onlytype.config.mybatisplus.PageVO;
import xyz.onlytype.entity.SysArticle;
import xyz.onlytype.mapper.SysMenuMapper;
import xyz.onlytype.service.SysArticleService;
import xyz.onlytype.mapper.SysArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author 白也
* @description 针对表【sys_article(文章标题)】的数据库操作Service实现
* @createDate 2023-02-23 11:45:28
*/
@Service
public class SysArticleServiceImpl extends ServiceImpl<SysArticleMapper, SysArticle>
    implements SysArticleService{
    @Autowired
    private SysArticleMapper sysArticleMapper;
    /**
     * 分页查询文章列表
     * @param pageNum 分页条数
     * @param pageSize 分页大小
     * @return
     */

    @Override
    public PageVO<SysArticle> pageList(int pageNum, int pageSize) {
        return PageVO.pageList(sysArticleMapper.selectPage(new Page<>(pageNum,pageSize),null));
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
        return sysArticleMapper.insert(article) > 0;
    }

    /**
     * 文章删除
     *
     * @param articleId 文章id
     * @return
     */
    @Override
    public Boolean deleteArticle(String articleId) {
        return sysArticleMapper.deleteById(articleId) >0 ;
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
        return sysArticleMapper.updateById(article) > 0;
    }
}




