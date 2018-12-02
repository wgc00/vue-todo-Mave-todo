package com.wgc.todo.service.Imp;

import com.wgc.todo.dao.TodoMapper;
import com.wgc.todo.entity.Todo;
import com.wgc.todo.exception.DatabaseException;
import com.wgc.todo.exception.DateValidateException;
import com.wgc.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImp implements ToDoService {

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public void deleteByPrimaryKey(Integer id) throws DateValidateException {
        int i = todoMapper.deleteByPrimaryKey(id);
        if (i == 0) {
            throw new DateValidateException("删除失败，请重新删除");
        }
    }

    @Override
    public void insert(Todo record) throws  DateValidateException {
        String name = record.getName();
        int insert = todoMapper.insert(record);
        if (insert == 0) {
            throw new DateValidateException("您写入的信息有误，请重新输入");
        }
    }

    @Override
    public Todo selectByPrimaryKey(Integer id) {
        Todo todo = todoMapper.selectByPrimaryKey(id);
        return todo;
    }

    @Override
    public List<Todo> selectAll() throws DatabaseException {
        List<Todo> todos = todoMapper.selectAll();
        if (todos == null) {
            throw new DatabaseException();
        }
        return todos;
    }

    @Override
    public void updateByPrimaryKey(Todo record) {
        int i = todoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Todo> selectState(String state) {
        List<Todo> todos = todoMapper.selectState(state);
        return todos;
    }

    @Override
    public void updateState(String state, int id) {
        int i = todoMapper.updateByState(state, id);
    }


}
