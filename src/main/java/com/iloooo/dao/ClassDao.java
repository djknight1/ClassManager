package com.iloooo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.iloooo.entity.Class;
import java.util.List;

@Mapper
public interface ClassDao {
    @Select("select * from class where Id = #{Id}")
    Class selectById(int Id);
    @Select("select * from class where classname = #{classname}")
    Class selectByClassName(String classname);

    @Select("select * from class")
    List<Class> selectClassAll();
}
