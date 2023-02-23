package xyz.onlytype.controller.menu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.service.SysMenuService;
import xyz.onlytype.service.SysUserService;

/**
 * @author 白也
 * @title 菜单管理
 * @date 2023/2/23 9:27 上午
 */

@Api(value = "/api/userManagement", tags = {""})
@RestController
@RequestMapping("/api/userManagement")
public class SysMenuController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 角色菜单查询
     *
     * @return 菜单信息
     */
    @ApiOperation(value = "查询菜单列表", notes = "查询菜单列表", httpMethod = "GET")

    @GetMapping("/menus")
    public ResultModel selectMenuList() {
        return ResultModel.ok(sysUserService.findByUserinfo());
    }

    /**
     * 新增菜单
     *
     * @param sysMenu 新增菜单
     * @return true/false
     */

    @ApiOperation(value = "新增菜单", notes = "新增菜单", httpMethod = "POST")
    @PostMapping("/addMenu")
    public ResultModel addMenu(SysMenu sysMenu) {
        return ResultModel.ok(sysMenuService.addMenu(sysMenu));
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单Id
     * @return true/false
     */

    @ApiOperation(value = "删除菜单", notes = "删除菜单", httpMethod = "DELETE")
    @DeleteMapping
    public ResultModel deleteMenu(String menuId) {
        return ResultModel.ok(sysMenuService.deleteMenu(menuId));
    }

    /**
     * 修改菜单
     *
     * @param sysMenu 菜单信息
     * @return true/false
     */

    @ApiOperation(value = "修改菜单", notes = "修改菜单", httpMethod = "PUT")
    @PutMapping
    public ResultModel updateMenu(SysMenu sysMenu) {
        return ResultModel.ok(sysMenuService.updateMenu(sysMenu));
    }


}
