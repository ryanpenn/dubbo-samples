package cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "login_name")
    private String loginName;
    private String password;
    private String nickname;
    private String email;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "register_date")
    private Date registerDate;
}
