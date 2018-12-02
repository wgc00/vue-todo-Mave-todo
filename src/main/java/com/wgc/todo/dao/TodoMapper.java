package com.wgc.todo.dao;

import com.wgc.todo.entity.Todo;
import java.util.List;

public interface TodoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Todo record);

    Todo selectByPrimaryKey(Integer id);

    List<Todo> selectAll();

    int updateByPrimaryKey(Todo record);

    List<Todo> selectState(String state);

    int updateByState(String state, int id);
}