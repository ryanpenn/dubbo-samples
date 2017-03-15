package cn.ryanpenn.dubbo.samples.shop.service.user.service;

import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserService;
import cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity.UserEntity;
import cn.ryanpenn.dubbo.samples.shop.service.user.persist.repository.UserRepository;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * UserServiceImpl
 */
@Component
@Service(version = "1.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int register(UserInfo userInfo) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userInfo, userEntity);

        int id = -1;
        userRepository.insertAndGetId(userEntity);
        return userEntity.getId();
    }

    @Override
    public UserInfo login(String loginName, String password) {
        UserEntity userEntity = userRepository.selectByLogin(loginName, password);
        if (userEntity==null)
            return null;

        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(userEntity, info);
        return info;
    }

    @Override
    public void logout(int userId) {

    }

    @Override
    public UserInfo findById(int userId) {
        UserEntity userEntity = userRepository.selectByPrimaryKey(userId);

        UserInfo userInfo = UserInfo.builder().id(-1).build();
        BeanUtils.copyProperties(userEntity, userInfo);

        if (userInfo.getId()!=-1)
            return userInfo;
        else
            return null;
    }

    @Override
    public boolean isLogin(int userId) {
        UserEntity userEntity = userRepository.getOne(userId);
        if (userEntity!=null && userEntity.getId()==userId)
            return true;

        return false;
    }

    @Override
    public boolean isExist(String loginName) {
        return userRepository.isExsit(loginName) > 0;
    }
}
