package xyz.onlytype.utils;

import org.apache.commons.lang.StringUtils;
import xyz.onlytype.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 白也
 * @title
 * @date 2023/2/24 2:37 下午
 */
public class SysMenuTree {
    public static void treeUtils(ArrayList<SysMenu> menuArrayList, List<SysMenu> sysMenus) {
        for (SysMenu menu : sysMenus) {
            //获取父节点
            if (StringUtils.isEmpty(menu.getParentCode())){
                menuArrayList.add(menu);
            }
            for (SysMenu  childNode: sysMenus) {
                if (menu.getMenuCode().equals(childNode.getParentCode())) {
                    menu.addChild(childNode);
                }
            }
        }
    }
}
