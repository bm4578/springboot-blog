package xyz.onlytype.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章标题(SysArticle)表实体类
 *
 * @author 白也
 * @since 2023-02-20 10:47:27
 */
@SuppressWarnings("serial")
@Data
public class SysArticle extends Model<SysArticle> {
    //主键id
    private String articleId;
    //用户id
    private String uid;
    //文章标题
    private String articleTitle;
    //文章主体
    private String articleList;
    //博客类型
    private String articleType;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date articleCreate = new Date();
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date articleUpdate = new Date();

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }
    }

