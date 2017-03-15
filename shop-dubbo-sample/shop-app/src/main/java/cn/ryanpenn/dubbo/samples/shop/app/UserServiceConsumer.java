package cn.ryanpenn.dubbo.samples.shop.app;

import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * UserServiceConsumer
 */
@Component
public class UserServiceConsumer {

    @Reference(version = "1.0")
    private UserService userService;

    public void login() {
        UserInfo userInfo = userService.login("test", "123");
        System.out.println(userInfo);
    }

    public boolean register() {

        String loginName = "test";

        if(userService.isExist(loginName)) {
            System.out.println("user exist.");
            return false;
        }

        UserInfo userInfo = UserInfo.builder()
                .loginName(loginName)
                .password("123")
                .nickname("kk")
                .email("kafka@apache.com")
                .build();

        int id = userService.register(userInfo);
        userInfo.setId(id);
        System.out.println("new user:" + userInfo);
        return true;
    }
}
