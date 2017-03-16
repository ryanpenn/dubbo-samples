package cn.ryanpenn.dubbo.samples.shop.service.order.service;

import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.order.OrderService;

/**
 * OrderServiceImpl
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public int submit(OrderInfo orderInfo) {
        return 0;
    }

    @Override
    public void cancelOrderById(int id) {

    }

    @Override
    public OrderInfo findOrderByUserId(int userId) {
        return null;
    }
}
