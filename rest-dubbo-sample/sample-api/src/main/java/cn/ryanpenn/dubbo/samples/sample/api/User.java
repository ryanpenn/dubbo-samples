package cn.ryanpenn.dubbo.samples.sample.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;

    private int age;

}
