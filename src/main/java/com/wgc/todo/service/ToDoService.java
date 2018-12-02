package com.wgc.todo.service;

import com.wgc.todo.entity.Todo;
import com.wgc.todo.exception.DatabaseException;
import com.wgc.todo.exception.DateValidateException;

import java.util.List;

public interface ToDoService {

    void deleteByPrimaryKey(Integer id) throws DateValidateException;

    void insert(Todo record) throws DateValidateException;

    Todo selectByPrimaryKey(Integer id);

    List<Todo> selectAll() throws DatabaseException;

    void updateByPrimaryKey(Todo record);

    List<Todo> selectState(String state);

    void updateState(String state, int id);
}
