package cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity;

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
 * UserEntity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String loginName;
    private String password;
    private String nickname;
    private String email;
    private Date lastLoginTime;
    private Date registerDate;
}
