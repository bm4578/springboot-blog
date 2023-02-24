package xyz.onlytype.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.service.SysUserService;

/**
 * @author 白也
 * @title
 * @date 2023/2/24 10:35 上午
 */

@Api(value = "/api/userInfo", tags = {"用户基本信息"})
@RestController
@RequestMapping("/api/userInfo")
public class UserInfo {
    @Autowired
    private SysUserService sysUserService;

    /**
     *用户基本信息查询
     * @return 菜单信息
     */
    @ApiOperation(value = "用户基本信息", notes = "用户基本信息", httpMethod = "GET")

    @GetMapping
    public ResultModel selectMenuList() {
        return ResultModel.ok(sysUserService.findByUserinfo());
    }
}
