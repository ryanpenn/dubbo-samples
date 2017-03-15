package cn.ryanpenn.dubbo.samples.shop.service.user;

import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserService;
import cn.ryanpenn.dubbo.samples.shop.service.user.config.AppConfiguration;
import cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity.UserEntity;
import cn.ryanpenn.dubbo.samples.shop.service.user.persist.repository.UserRepository;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * UserServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_login(){

        assertNotNull(userService);

        UserInfo userInfo = userService.login("kafka","123");
        assertNotNull(userInfo);

        int id = userInfo.getId();
        System.out.println(userService.isLogin(id));
    }

    @Test
    public void test_page(){

        // HowToUse
        // https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md

        PageHelper.startPage(1, 1);
        List<UserEntity> list = userRepository.selectAll();
        list.forEach(System.out::println);

        System.out.println();

        PageHelper.startPage(1, 5);
        list = userRepository.selectAll();
        list.forEach(System.out::println);
    }

}
