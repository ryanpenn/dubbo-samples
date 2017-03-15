package cn.ryanpenn.dubbo.samples.shop.service.user.persist.repository;

import cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * 用户表操作
 *
 * UserRepository
 * extends Mapper 自动实现常见的CRUD操作
 */
public interface UserRepository  extends Mapper<UserEntity> {
    /**
     * 通过注解实现Mapper
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_users WHERE id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "displayName", column = "display_name")
    })
    UserEntity getOne(Long id);

    /**
     * 通过XML文件实现Mapper（classpath:persist.repository/UserMapper.xml）
     * @param login
     * @return
     */
    UserEntity selectByLogin(String login);
}
