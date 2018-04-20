package com.iloooo.dao;

import com.iloooo.bean.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TaskDao {
    @Insert("insert into task(Id, typeId, name, formatName,endTime, flag)values(#{Id}, #{typeId}, #{name}, #{formatName}, #{endTime}, #{flag})")
    boolean insertTask(Task task);

    @Select("select * from task where id = #{id}")
    Task selectByTaskId(long id);

    @Select("select * from task where flag = 1")
    List<Task> selectTaskNow();
}
