package xyz.onlytype.controller.blogPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.entity.SysPage;
import xyz.onlytype.service.SysPageService;

/**
 * @author 白也
 * @title 首页菜单信息(公开访问)
 * @date 2023/2/23 4:50 下午
 */
@Api(value = "/api/article/menu", tags = {"首页菜单"})
@RestController
@RequestMapping("/api/article/menu")
public class SysPageController {
    @Autowired
    private SysPageService sysPageService;

    /**
     * 查询首页菜单
     *
     * @return
     */

    @ApiOperation(value = "查询首页菜单", notes = "查询首页菜单", httpMethod = "GET")
    @GetMapping
    public ResultModel queryPageList() {
        return ResultModel.ok(sysPageService.selectPage());
    }

    /**
     * 新增菜单
     *
     * @param sysPage 新增菜单
     * @return true/false
     */

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "SysPage", name = "sysPage", value = "新增菜单", required = true)
    })
    @ApiOperation(value = "新增菜单", notes = "新增菜单", httpMethod = "POST")
    @PostMapping
    public ResultModel addPageMenu(SysPage sysPage) {
        return ResultModel.ok(sysPageService.addMenu(sysPage));
    }
    /**
     * 修改菜单
     *
     * @param sysPage 菜单信息
     * @return true/false
     */


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "SysPage", name = "sysPage", value = "菜单信息", required = true)
    })
    @ApiOperation(value = "修改菜单", notes = "修改菜单", httpMethod = "PUT")
    @PutMapping
    public ResultModel updatePageMenu(SysPage sysPage) {
        return ResultModel.ok(sysPageService.updateMenu(sysPage));
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
    public ResultModel deletePageMenu(Long menuId) {
        return ResultModel.ok(sysPageService.deleteMenu(menuId));
    }
}
