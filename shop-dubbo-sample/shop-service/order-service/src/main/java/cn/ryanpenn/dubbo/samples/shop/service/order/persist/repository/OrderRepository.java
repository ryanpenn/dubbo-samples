package cn.ryanpenn.dubbo.samples.shop.service.order.persist.repository;

import cn.ryanpenn.dubbo.samples.shop.service.order.persist.entity.OrderEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * OrderRepository
 */
@Repository
public interface OrderRepository extends Mapper<OrderEntity> {

    List<OrderEntity> searchByUserId(Integer userId);

}
