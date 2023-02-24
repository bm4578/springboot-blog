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

@Api(value = "/api/menu", tags = {"菜单管理"})
@RestController
@RequestMapping("/api/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 所有菜单查询
     * @return
     */
    @ApiOperation(value = "所有菜单查询", notes = "所有菜单查询", httpMethod = "GET")
    @GetMapping
    public ResultModel queryAll(){
        return ResultModel.ok(sysMenuService.seleteAllMenus());
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
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "menuId", value = "菜单Id", required = true)
    })
    @ApiOperation(value = "删除菜单", notes = "删除菜单", httpMethod = "DELETE")
    @DeleteMapping
    public ResultModel deleteMenu(Long menuId) {
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
     * 新增角色菜单
     * @param sysRoleMenu 用户信息
     * @return true/false
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "SysRoleMenu", name = "sysRoleMenu", value = "用户信息", required = true)
    })
    @ApiOperation(value = "新增角色菜单", notes = "新增角色菜单", httpMethod = "POST")
    @PostMapping("/addUserMenu")
    public ResultModel addUserMenu(SysRoleMenu sysRoleMenu){
        return ResultModel.ok(sysRoleMenuService.addRoleMenu(sysRoleMenu));
    }


    /**
     * 删除角色菜单
     * @param roleMenuId 用户id
     * @return true/false
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "roleMenuId", value = "用户id", required = true)
    })
    @ApiOperation(value = "删除角色菜单", notes = "删除角色菜单", httpMethod = "DELETE")
    @DeleteMapping("/deleteUserMenu")
    public ResultModel deleteUserMenu(String roleMenuId){
        return ResultModel.ok(sysRoleMenuService.deleteRoleMenu(roleMenuId));
    }

}
