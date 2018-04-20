package com.iloooo.dao;

import com.iloooo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where username=#{username}")
    User selectByUsername(@Param("username") String username);

    @Select("select * from user where username=#{id}")
    User selectById(@Param("id") long id);

    @Insert("insert into user(id,username,password,nickname,mobilephone,email) values(#{id},#{username},#{password},#{nickname},#{mobilephone},#{email})")
    boolean insertUser(User user);
}
