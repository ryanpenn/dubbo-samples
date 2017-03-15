package cn.ryanpenn.dubbo.samples.shop.service.api.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ProductInfo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInfo implements Serializable {
    private int id;
    private String name;
    private double price;
    private Date productionDate;
    private String factory;
    private int stock;
}
