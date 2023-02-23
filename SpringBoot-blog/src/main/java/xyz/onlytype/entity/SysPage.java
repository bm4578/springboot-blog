package xyz.onlytype.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 页面基本信息

 * @TableName sys_page
 */
@TableName(value ="sys_page")
@Data
public class SysPage implements Serializable {
    /**
     * 菜单id
     */
    @TableId
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * code
     */
    private String menuCode;

    /**
     * type
     */
    private String menuType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}