package cn.ryanpenn.dubbo.samples.shop.service.product;

import cn.ryanpenn.dubbo.samples.shop.service.product.provider.ProductServiceProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * ProductServiceTest
 * - springboot 1.3.2的写法与1.4.3的有所不同，参考order-service项目的单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductServiceProvider.class)
public class ProductServiceTest {

    @Test
    public void productTest(){
        assertTrue(true);
    }
}
