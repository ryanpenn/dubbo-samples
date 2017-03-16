package cn.ryanpenn.dubbo.samples.shop.service.product.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * ProductEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Date productionDate;
    private String factory;
    private Integer stock;
    private Date creationDate;
}
