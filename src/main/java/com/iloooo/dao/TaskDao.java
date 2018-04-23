package com.iloooo.dao;

import com.iloooo.bean.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TaskDao {
    @Insert("insert into task(Id, typeId, name, formatName,endTime, flag,taskPath)values(#{Id}, #{typeId}, #{name}, #{formatName}, #{endTime}, #{flag}, #{taskPath})")
    boolean insertTask(Task task);

    @Select("select * from task where id = #{id}")
    Task selectByTaskId(long id);

    @Select("select * from task where flag = 1")
    List<Task> selectTaskNow();

    @Select("select * from task where flag = 1 and typeId = #{typeId}")
    Task selectTaskNowByTypeId(long typeId);

    @Select("select * from task where typeId = #{typeId}")
    List<Task> selectTaskByTypeId(long typeId);
}
