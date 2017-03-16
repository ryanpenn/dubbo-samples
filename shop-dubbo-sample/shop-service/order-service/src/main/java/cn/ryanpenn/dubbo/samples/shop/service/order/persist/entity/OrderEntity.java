package cn.ryanpenn.dubbo.samples.shop.service.order.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * OrderEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer status;
    private Integer buyerId;
    private Date orderTime;
    private String receiver;
    private Double amount;
    @Transient
    private List<Integer> productIdList;
}
