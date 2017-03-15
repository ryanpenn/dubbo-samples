package cn.ryanpenn.dubbo.samples.shop.service.api.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * OrderInfo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo implements Serializable {
    private int id;
    private int status;
    private int buyerId;
    private List<Integer> productIdList;
}
