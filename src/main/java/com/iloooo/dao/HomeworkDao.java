package com.iloooo.dao;

import com.iloooo.bean.Homework;
import org.apache.ibatis.annotations.*;

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

    @Update("Update homework set userId=#{homework.userId}, typeId=#{homework.typeId}, taskId= #{homework.taskId}, name=#{homework.name}, path=#{homework.path}, time=#{homework.time} where id=#{homework.id}")
    boolean updateHomework(@Param("homework") Homework homework);

    @Select("select * from homework where userId=#{userId} and taskId = #{taskId}")
    Homework selectByUserIdAndTaskId(@Param("userId") long userId,@Param("taskId") long taskId);

    @Select("select * from homework")
    List<Homework> selectAllHomework();

}
