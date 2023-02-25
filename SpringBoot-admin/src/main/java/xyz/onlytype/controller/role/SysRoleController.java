package xyz.onlytype.controller.role;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.entity.SysRole;
import xyz.onlytype.entity.SysUserRole;
import xyz.onlytype.service.SysRoleService;
import xyz.onlytype.service.SysUserRoleService;

/**
 * @author 白也
 * @title 角色管理
 * @date 2023/2/22 6:04 下午
 */
@Api(value = "api/user/role", tags = {"角色管理"})
@RestController
@RequestMapping("api/user/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 查询所有角色信息
     * @return 角色id、角色名称
     */
   @ApiOperation(value = "查询所有角色信息", notes = "查询所有角色信息")
   @GetMapping
   public ResultModel selectAllRoleList(){
       return ResultModel.ok(sysRoleService.selectAllRoleList());
   }

    /**
     * 给用户赋予角色
     * @param sysUserRole 用户角色信息
     * @return 是否成功
     */
    @ApiOperation(value = "给用户赋予角色", notes = "给用户赋予角色", httpMethod = "POST")
    @PutMapping("/addUserRole")
    public ResultModel addUserRole(SysUserRole sysUserRole){
        if (sysUserRoleService.addUserRole(sysUserRole)){
            return ResultModel.ok("添加成功");
        } else {
            return ResultModel.error("添加失败");
        }
    }

    /**
     * 查询用户的角色信息
     * @return 用户角色列表
     */
    @ApiOperation(value = "查询用户的角色信息", notes = "查询用户的角色信息", httpMethod = "POST")
    @PostMapping("/selectUserRole")
    public ResultModel selectUserRole(){
        return ResultModel.ok(sysRoleService.selectUserRole());
    }

    /**
     * 添加角色
     * @param sysRole 角色添加
     * @return 是否成功
     */
    @ApiOperation(value = "添加角色", notes = "", httpMethod = "POST")
    @PostMapping("/addRole")
    public ResultModel addRole(SysRole sysRole){
        if (sysRoleService.addRole(sysRole)) {
            return ResultModel.ok("添加成功");
        } else {
            return ResultModel.error("添加失败");
        }
    }

    /**
     *
     * @param userRoleId
     * @return
     */
    @DeleteMapping
    public ResultModel deleteUserRole(String userRoleId){
        return ResultModel.ok(sysUserRoleService.deleteUserRole(userRoleId));
    }


}
