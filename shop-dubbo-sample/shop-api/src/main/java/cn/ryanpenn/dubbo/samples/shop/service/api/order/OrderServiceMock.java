package cn.ryanpenn.dubbo.samples.shop.service.api.order;

/**
 * OrderService的本地伪装
 * - 只在出现RpcException时被执行
 *
 * @Ref Dubbo用户手册 http://dubbo.io/User+Guide-zh.htm
 */
public class OrderServiceMock implements OrderService {

    @Override
    public int submit(OrderInfo orderInfo) {
        // 返回容错数据，此方法只在出现RpcException时被执行
        return -1;
    }

    @Override
    public void cancelOrderById(int id) {

    }

    @Override
    public OrderInfo findOrderByUserId(int userId) {
        return null;
    }
}
