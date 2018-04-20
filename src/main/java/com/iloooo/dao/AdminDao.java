package com.iloooo.dao;

import com.iloooo.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AdminDao {
    @Select("select * from admin where id = #{id}")
    Admin selectById(int id);
    @Select("select * from admin where username = #{username}")
    Admin selectByUsername(String username);
}
