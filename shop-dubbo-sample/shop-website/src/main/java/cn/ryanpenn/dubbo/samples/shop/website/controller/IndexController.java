package cn.ryanpenn.dubbo.samples.shop.website.controller;

import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserInfo;
import cn.ryanpenn.dubbo.samples.shop.website.service.ServiceProvider;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @Autowired
    ServiceProvider provider;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) throws ExecutionException, InterruptedException {

        UserInfo userInfo = provider.getUserService().login("test01", "123");

        // async Invoke
        {
            provider.getOrderService().findOrderByUserId(userInfo.getId());
            Future<OrderInfo> future = RpcContext.getContext().getFuture();

            // Invoke OrderService async
            OrderInfo info = future.get();
            System.out.println("OrderInfo:" + info);
        }

        // sync Invoke
        {
            int result = provider.getOrderService().submit(OrderInfo.builder()
                    .buyerId(userInfo.getId())
                    .status(1)
                    .orderTime(new Date())
                    .receiver("receiver address")
                    .amount(1.0F)
                    .build());
            System.out.println("submit:" + result);
        }


        model.addAttribute("title", "Welcome");
        model.addAttribute("message", userInfo);
        return "home";
    }

}
