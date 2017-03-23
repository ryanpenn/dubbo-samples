package cn.ryanpenn.dubbo.samples.shop.website.controller;

import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.product.ProductInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.user.UserInfo;
import cn.ryanpenn.dubbo.samples.shop.website.service.ServiceProvider;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
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

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    @ResponseBody
    public String echo() {
        // 强制转型为EchoService，进行回声测试
        EchoService echoService = (EchoService) (provider.getUserService());
        if (echoService!=null)
            return  (String) echoService.$echo("OK"); // 回声测试可用性
        else
            return "ProductService 不可用";
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductInfo> product(){

        return provider.getProductService().list();
        // RPC Info
        //boolean isConsumerSide = RpcContext.getContext().isConsumerSide(); // 本端是否为消费端，这里会返回true
        //String serverIP = RpcContext.getContext().getRemoteHost(); // 获取最后一次调用的提供方IP地址
        //String application = RpcContext.getContext().getUrl().getParameter("application"); // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
    }

}
