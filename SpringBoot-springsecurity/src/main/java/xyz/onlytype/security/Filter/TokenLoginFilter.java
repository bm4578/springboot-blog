package xyz.onlytype.security.Filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import xyz.onlytype.entity.SecurityUser;
import xyz.onlytype.config.utils.ResponseUtils;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.security.exception.CustomerAuthenionException;
import xyz.onlytype.security.exception.PasswordException;
import xyz.onlytype.security.token.TokenManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 白也
 * @title 登录拦截
 * @date 2023/1/28 11:11 上午
 */

@Slf4j
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private TokenManager tokenManager;
    private RedisTemplate<String, Object> redisTemplate;
    private AuthenticationManager authenticationManager;

    public TokenLoginFilter(TokenManager tokenManager, RedisTemplate<String, Object> redisTemplate, AuthenticationManager authenticationManager) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.authenticationManager = authenticationManager;
        //允许其它请求认证
        this.setPostOnly(false);
        //设置登录路径
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/user/login", "POST"));
    }

    /**
     * 执行认证的方法
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            // TODO 验证码校验
            //1.获取登录请求的验证码
            String inputCode = request.getParameter("code");
            //判断验证码是否为空
            if(StringUtils.isEmpty(inputCode)) {
                log.error("验证码不能为空 ！");
                throw new CustomerAuthenionException("验证码不能为空!");
            }
            //从redis获取验证码
            Integer  imgCode = (Integer) redisTemplate.opsForValue().get("verifyCode");
            //判断验证码是否相等
            if(!inputCode.equalsIgnoreCase(String.valueOf(imgCode))){
                log.error("验证码输入错误 ！");
                throw new CustomerAuthenionException("验证码输入错误!");
            }
            //从表单中获取用户信息
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getParameter("username"),
                            request.getParameter("password")
                            , new ArrayList<>())
            );
        } catch (BadCredentialsException e){
            log.error("密码错误 ！");
            throw new PasswordException("密码错误 ! ! !");
        }
    }

    /**
     * 认证成功之后
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult the object returned from the <tt>attemptAuthentication</tt>
     *                   method.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        try {
            //为空时生成token
            SecurityUser principal = (SecurityUser) authResult.getPrincipal();
            List<String> permissionList = principal.getPermissionList();
            String token = null;
            for (String permissions : permissionList) {
                token = tokenManager.getToken(principal.getUsername(),permissions);
            }
            //存入redis
            assert token != null;
            redisTemplate.opsForValue().set("token", token, tokenManager.getRemainingTime(token), TimeUnit.MINUTES);
            // 返回生成的token
            ResponseUtils.out(response, ResultModel.ok(token));
        } catch (Exception e) {
            log.error("token生成异常");
            ResultModel.error("token生成异常", e.getMessage());
        }
    }

    /**
     * 认证失败
     *
     * @param request req
     * @param response res
     * @param exception 错误信息
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseUtils.out(response, ResultModel.error(501,exception.getMessage()));
    }
}
