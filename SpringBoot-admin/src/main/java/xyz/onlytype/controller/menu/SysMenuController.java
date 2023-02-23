package xyz.onlytype.controller.menu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.entity.SysRoleMenu;
import xyz.onlytype.service.SysMenuService;
import xyz.onlytype.service.SysRoleMenuService;
import xyz.onlytype.service.SysUserService;

/**
 * @author 白也
 * @title 权限菜单管理
 * @date 2023/2/23 9:27 上午
 */

@Api(value = "/api/userManagement", tags = {"菜单管理"})
@RestController
@RequestMapping("/api/userManagement")
public class SysMenuController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

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

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "SysMenu", name = "sysMenu", value = "新增菜单", required = true)
    })
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

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "menuId", value = "菜单Id", required = true)
    })
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

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "SysMenu", name = "sysMenu", value = "菜单信息", required = true)
    })
    @ApiOperation(value = "修改菜单", notes = "修改菜单", httpMethod = "PUT")
    @PutMapping
    public ResultModel updateMenu(SysMenu sysMenu) {
        return ResultModel.ok(sysMenuService.updateMenu(sysMenu));
    }

    /**
     * 新增用户菜单
     * @param sysRoleMenu 用户信息
     * @return true/false
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "SysRoleMenu", name = "sysRoleMenu", value = "用户信息", required = true)
    })
    @ApiOperation(value = "新增用户菜单", notes = "新增用户菜单", httpMethod = "POST")
    @PostMapping("/addUserMenu")
    public ResultModel addUserMenu(SysRoleMenu sysRoleMenu){
        return ResultModel.ok(sysRoleMenuService.addUserMenu(sysRoleMenu));
    }


    /**
     * 删除用户菜单
     * @param roleMenuId 用户id
     * @return true/false
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "roleMenuId", value = "用户id", required = true)
    })
    @ApiOperation(value = "删除用户菜单", notes = "删除用户菜单", httpMethod = "DELETE")
    @DeleteMapping("/deleteUserMenu")
    public ResultModel deleteUserMenu(String roleMenuId){
        return ResultModel.ok(sysRoleMenuService.deleteUserMenu(roleMenuId));
    }

}
