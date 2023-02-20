package xyz.onlytype.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.onlytype.entity.SysUser;
import xyz.onlytype.vo.UserInfoVo;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author 白也
 * @since 2023-01-28 11:23:37
 */
public interface SysUserService extends IService<SysUser>{
    /**
     * 发送邮箱信息
     * @param recipient 收件人
     * @param template 模板
     * @param message 信息
     */
    void sendMessage(String recipient,String template,String message);

    /**
     * 用户信息查询
     * @return 用户列表
     */
    UserInfoVo findByUserinfo();

    /**
     * 逻辑删除
     * @param userId 用户id
     * @return true/false
     */
    Boolean deleteUser(String userId);

    /**
     * 恢复删除用户
     * @param userId 用户id
     * @return true/false
     */
    Boolean recoverUser(String userId);

}

