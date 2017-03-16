package cn.ryanpenn.dubbo.samples.shop.website.service;

import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderService;
import cn.ryanpenn.dubbo.samples.shop.service.api.product.ProductService;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * ServiceProvider
 */
@Component
public class ServiceProvider {

    @Getter
    @Reference(version = "1.0")
    private UserService userService;

    @Getter
    @Reference(version = "1.0")
    private ProductService productService;

    @Getter
    @Reference(version = "1.0")
    private OrderService orderService;

}
