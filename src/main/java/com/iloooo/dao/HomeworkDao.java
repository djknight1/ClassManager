package com.iloooo.dao;

import com.iloooo.bean.Homework;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface HomeworkDao {
    @Insert("insert into homework(Id, userId, typeId, taskId, name, path, time)values(#{Id}, #{userId}, #{typeId}, #{taskId}, #{name}, #{path}, #{time})")
    boolean insertHomework(Homework homework);
    @Delete("delete from homework where Id = #{Id}")
    boolean deleteById(long Id);
    @Select("select * from homework where userId = #{userId}")
    Homework selectByUserId(long userId);
    @Select("select * from homework where typeId = #{typeId}")
    List<Homework> selectByTypeId(long typeId);
    @Select("select * from homework where taskId = #{taskId}")
    List<Homework> selectByTaskId(long taskId);
    @Select("select * from homework")
    List<Homework> selectAllHomework();

}
