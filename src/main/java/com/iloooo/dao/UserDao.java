package com.iloooo.dao;

import com.iloooo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user where id=#{id}")
    User selectById(@Param("id") long id);

    @Select("select * from user where classId = #{classId}")
    List<User> selectByClassId(int classId);

    @Insert("insert into user(id,classId,password,name) values(#{id},#{classId},#{password},#{name})")
    boolean insertUser(User user);

    @Update("update user set classId=#{classId},password=#{password},name=#{name} where id=#{id}")
    boolean updateUser(User user);
}
