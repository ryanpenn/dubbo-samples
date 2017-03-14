package cn.ryanpenn.dubbo.samples.shop.service.api.user;

import java.util.List;

/**
 * UserService
 */
public interface UserService {

    /**
     * 注册
     * @param userInfo
     * @return
     */
    int register(UserInfo userInfo);

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    UserInfo login(String loginName, String password);

    /**
     * 退出
     * @param userId
     */
    void logout(int userId);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserInfo findById(int userId);

    /**
     * 判断用户是否登录
     * @param userId
     * @return
     */
    boolean isLogin(int userId);
}
