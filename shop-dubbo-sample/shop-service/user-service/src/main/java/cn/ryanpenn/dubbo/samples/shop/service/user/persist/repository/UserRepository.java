package cn.ryanpenn.dubbo.samples.shop.service.user.persist.repository;

import cn.ryanpenn.dubbo.samples.shop.service.user.persist.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * 用户表操作
 *
 * UserRepository
 * extends Mapper 自动实现常见的CRUD操作
 */
@Repository
public interface UserRepository extends Mapper<UserEntity> {
    /**
     * 通过注解实现Mapper
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "loginName", column = "login_name")
    })
    UserEntity getOne(Integer id);

    /**
     * 通过XML文件实现Mapper（classpath:persist.mapper/UserMapper.xml）
     *
     * @param login
     * @return
     */
    UserEntity selectByLogin(@Param("login") String login, @Param("password") String password);

    /**
     * 新增并返回ID
     *
     * @param user
     * @return
     */
    int insertAndGetId(UserEntity user);

    @Select("SELECT COUNT(1) FROM tb_user WHERE login_name = #{loginName}")
    int isExsit(String loginName);
}
