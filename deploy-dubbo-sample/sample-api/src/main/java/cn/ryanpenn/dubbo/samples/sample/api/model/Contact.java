package cn.ryanpenn.dubbo.samples.sample.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Contact.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact implements Serializable {

    int id;
    String name;
    String phone;
    String email;
    Address address;
    String memo;

}
