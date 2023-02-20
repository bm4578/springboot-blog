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
    @Override
    public PageVO<SysArticle> pageList(int pageNum, int pageSize) {
        return PageVO.pageList(sysArticleDao.selectPage(new Page<>(pageNum,pageSize),null));
    }
}

