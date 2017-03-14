package cn.ryanpenn.dubbo.samples.shop.service.api.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * UserInfo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo implements Serializable {
    private int id;
    private String loginName;
    private String password;
    private String nickname;
    private String email;
    private Date lastLoginTime;
}
