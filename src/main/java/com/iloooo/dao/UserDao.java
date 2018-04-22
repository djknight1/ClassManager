package com.iloooo.dao;

import com.iloooo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user where username=#{id}")
    User selectById(@Param("id") long id);

    @Select("select * from user where classId = #{classId}")
    List<User> selectByClassId(int classId);

    @Insert("insert into user(id,classId,password,name) values(#{id},#{classId},#{password},#{name})")
    boolean insertUser(User user);
}
