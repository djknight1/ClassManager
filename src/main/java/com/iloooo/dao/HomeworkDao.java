package com.iloooo.dao;

import com.iloooo.bean.Homework;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HomeworkDao {
    @Insert("insert into homework(Id, userId, typeId, taskId, path, time)values(#{Id}, #{userId}, #{typeId}, #{taskId}, #{path}, #{time})")
    boolean insertHomework(Homework homework);
    @Delete("delete from homework where Id = #{Id}")
    boolean deleteById(int Id);
    @Select("select * from homework where userId = #{userId}")
    Homework selectByUserId(int userId);
    @Select("select * from homework where typeId = #{typeId}")
    List<Homework> selectByTypeId(int typeId);
    @Select("select * from homework where taskId = #{taskId}")
    List<Homework> selectByTaskId(int taskId);
    @Select("select * from homework")
    List<Homework> selectAllHomework();

}
