package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章标题
 * @TableName sys_article
 */
@TableName(value ="sys_article")
@Data
public class SysArticle implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long articleId;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章主体
     */
    private String articleList;

    /**
     * 博客类型
     */
    private String articleType;

    /**
     * 创建时间
     */
    private Date articleCreate;

    /**
     * 更新时间
     */
    private Date articleUpdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}