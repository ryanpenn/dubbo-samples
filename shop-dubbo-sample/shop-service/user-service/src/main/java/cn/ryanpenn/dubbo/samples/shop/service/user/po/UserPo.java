package cn.ryanpenn.dubbo.samples.shop.service.user.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserPo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo {
    private int id;
    private String loginName;
    private String password;
    private String nickname;
    private String email;
    private Date lastLoginTime;
    private Date registerDate;
}
