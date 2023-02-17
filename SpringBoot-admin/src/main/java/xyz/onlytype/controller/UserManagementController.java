package xyz.onlytype.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.service.SysUserService;

/**
 * @author 白也
 * @title 用户管理
 * @date 2023/2/14 8:39 下午
 */
@Api(value = "/api/userManagement", tags = {"用户管理"})
@RestController
@RequestMapping("/api/userManagement")
public class UserManagementController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 用户基本信息
     * @return  文件列表
     */
    @ApiOperation(value = "查询菜单列表", notes = "查询菜单列表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "token",name = "token",paramType  = "header", dataType = "String", required=true)
    })
    @GetMapping("/menus")
    public ResultModel selectMenuList(){
        try {
            return ResultModel.ok(sysUserService.findByUserinfo());
        } catch (Exception e) {
            return ResultModel.error("查询失败",e.getMessage());
        }
    }

}
