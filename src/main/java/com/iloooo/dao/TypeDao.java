package com.iloooo.dao;

import com.iloooo.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeDao {

    @Select("Select * from type")
    List<Type> selectTypeAll();

    @Select("Select * from type where id = #{id}")
    Type selectTypeById(Long id);

}
