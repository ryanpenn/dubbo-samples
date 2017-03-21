package cn.ryanpenn.dubbo.samples.shop.service.order.service;

import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderService;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * OrderServiceImpl
 */
@Component
@Service(version = "1.0")
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0", async = true)
    UserService userService;

    @Override
    public int submit(OrderInfo orderInfo) {
        System.out.println("submit " + orderInfo);
        return 0;
    }

    @Override
    public void cancelOrderById(int id) {

    }

    @Override
    public OrderInfo findOrderByUserId(int userId) {
        userService.isLogin(userId);
        Future<Boolean> result = RpcContext.getContext().getFuture();

        try {

            // Invoke UserService async
            if (result.get().booleanValue()) {
                System.out.println("User is login.");

                // TODO 根据 userId 查询订单

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}
