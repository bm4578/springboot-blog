package xyz.onlytype.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import xyz.onlytype.dao.SysMenuDao;
import xyz.onlytype.dao.SysUserDao;
import xyz.onlytype.entity.SecurityUser;
import xyz.onlytype.entity.SysMenu;
import xyz.onlytype.entity.SysUser;
import xyz.onlytype.security.token.TokenManager;
import xyz.onlytype.service.SysUserService;
import org.springframework.stereotype.Service;
import xyz.onlytype.vo.UserInfoVo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author 白也
 * @since 2023-01-28 11:23:37
 */
@Schema(description = "用户表(SysUser)表服务实现类")
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService{
    @Schema(hidden = true)
    @Value("${spring.mail.username}")
    // 邮件发送人
    private String sender;
    @Schema(hidden = true)
    @Autowired
    private JavaMailSender mailSender;
    @Schema(hidden = true)
    @Autowired
    private SysUserDao sysUserDao;
    @Schema(hidden = true)
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private SysMenuDao sysMenuDao;
    /**
     * 发送邮箱信息
     *
     * @param recipient 收件人
     * @param template  模板
     * @param message   信息
     */
    @Override
    public void sendMessage(String recipient, String template, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发件人
        simpleMailMessage.setFrom(sender);
        //收件人
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setSubject(template);
        simpleMailMessage.setText(message);
        //发送邮件
        mailSender.send(simpleMailMessage);
    }

    /**
     * 获取权限菜单
     * @return
     */

    @Override
    public UserInfoVo findByUserinfo() {
        //获取token
        String token= (String)SecurityContextHolder.getContext().getAuthentication().getCredentials();
        //解析token
        Claims claims = tokenManager.getClaimsFromToken(token);
        //基本信息
        UserInfoVo byUserinfo = sysUserDao.findByUserinfo(claims.getIssuer());
        //权限菜单查询
        //父级菜单
        List<SysMenu> sysMenus = sysUserDao.finMenuByUserRoles(claims.getSubject());
        //所有子菜单
        List<SysMenu> menuList = sysMenuDao.selectList(null);
        //子菜单查询
        for (SysMenu sysMenu : sysMenus) {
            ArrayList<SysMenu> menuArrayList = new ArrayList<>();
            for (SysMenu menu : menuList) {
                if (sysMenu.getMenuCode().equals(menu.getParentCode())){
                   menuArrayList.add(menu);
                }
            }
            sysMenu.setChildNode(menuArrayList);
        }
        byUserinfo.setSysMenus(sysMenus);
        return byUserinfo;
    }
}

