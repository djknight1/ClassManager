package com.iloooo.dao;

import com.iloooo.bean.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskDao {
    @Insert("insert into task(Id, typeId, name, formatname, flag)values(#{Id}, #{typeId}, #{name}, #{formatname}, #{flag})")
    boolean insertTask();
    @Select("select * from task where typeId = #{typeId}")
    List<Task> task(int typeId);
}
