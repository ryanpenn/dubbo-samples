package cn.ryanpenn.dubbo.samples.shop.service.user.service;

import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserService;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int register(UserInfo userInfo) {
        return 0;
    }

    @Override
    public UserInfo login(String loginName, String password) {
        return null;
    }

    @Override
    public void logout(int userId) {

    }

    @Override
    public UserInfo findById(int userId) {
        return null;
    }

    @Override
    public boolean isLogin(int userId) {
        return false;
    }
}
