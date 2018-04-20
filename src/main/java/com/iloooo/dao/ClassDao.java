package com.iloooo.dao;

import org.apache.ibatis.annotations.Select;

public interface ClassDao {
    @Select("select * from class where Id = #{Id}")
    Class selectById(int Id);
    @Select("select * from class where classname = #{classname}")
    Class selectByClassName(String classname);
}
