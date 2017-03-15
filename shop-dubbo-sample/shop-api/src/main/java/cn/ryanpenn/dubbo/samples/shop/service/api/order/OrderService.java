package cn.ryanpenn.dubbo.samples.shop.service.api.order;

/**
 * OrderService
 */
public interface OrderService {

    /**
     * 提交订单
     * @param orderInfo
     * @return 订单id
     */
    int submit(OrderInfo orderInfo);

    /**
     * 取消订单
     * @param id 订单id
     */
    void cancelOrderById(int id);

    /**
     * 查找用户的订单
     * @param userId 用户id
     * @return
     */
    OrderInfo findOrderByUserId(int userId);
}
