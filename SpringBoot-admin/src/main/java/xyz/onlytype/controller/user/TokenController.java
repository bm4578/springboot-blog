package xyz.onlytype.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.onlytype.security.token.TokenManager;

/**
 * @author 白也
 * @title token管理
 * @date 2023/2/14 8:44 下午
 */
@Api(value = "/api/token/", tags = {"token管理"})
@RestController
@RequestMapping("/api/token/")
public class TokenController {
    @Autowired
    private TokenManager tokenManager;


    @ApiImplicitParams({
            @ApiImplicitParam(value = "token",name = "token",paramType  = "header", dataType = "String", required=true)
    })
    @ApiOperation(value = "是否过期", notes = "", httpMethod = "POST")
    @PostMapping
    public Boolean judgeToken(){
        String token= (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return tokenManager.isTokenExpired(token);
    }
}
