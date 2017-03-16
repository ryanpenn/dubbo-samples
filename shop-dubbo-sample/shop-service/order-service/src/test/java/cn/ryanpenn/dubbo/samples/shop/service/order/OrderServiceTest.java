package cn.ryanpenn.dubbo.samples.shop.service.order;

import cn.ryanpenn.dubbo.samples.shop.service.order.provider.OrderServiceProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

/**
 * OrderServiceTest
 * - springboot 1.4.3的写法与1.3.2的有所不同，参考product-service项目的单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderServiceProvider.class})
public class OrderServiceTest {

    @Test
    public void orderTest(){
        assertTrue(true);
    }
}
