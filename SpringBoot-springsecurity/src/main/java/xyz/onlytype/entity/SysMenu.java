package xyz.onlytype.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.*;

/**
 * 菜单表
(SysMenu)表实体类
 *
 * @author 白也
 * @since 2023-02-12 20:44:31
 */
@SuppressWarnings("serial")
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    //菜单id
    private String menuId;
    //菜单名称
    private String menuName;
    //菜单图标
    private String menuIcon;
    //菜单URL
    private String menuUrl;
    //code
    private String menuCode;
    //父级code
    private String parentCode;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date createTime = new Date();
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime = new Date();

    @TableField(exist = false)
    private List<SysMenu> childNode;
    }

