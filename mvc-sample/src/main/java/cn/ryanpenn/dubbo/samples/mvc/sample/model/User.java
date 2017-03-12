package cn.ryanpenn.dubbo.samples.mvc.sample.model;

import lombok.Builder;
import lombok.Data;

/**
 * User
 */
@Data
@Builder
public class User {
    private int id;
    private String name;
    private String email;
}
