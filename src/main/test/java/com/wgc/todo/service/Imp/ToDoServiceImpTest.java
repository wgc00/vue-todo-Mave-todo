package com.wgc.todo.service.Imp;

import com.wgc.todo.dao.TodoMapper;
import com.wgc.todo.entity.Todo;
import com.wgc.todo.exception.DatabaseException;
import com.wgc.todo.service.ToDoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/*如果要测试类的头部一定要加上这两个注解*/
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class ToDoServiceImpTest {
    @Autowired
    private ToDoService toDoService;

    @Autowired
    private TodoMapper todoMapper;
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() throws DatabaseException {
       //System.out.println(todoMapper.selectAll());
        List<Todo> todos = toDoService.selectAll();
        for (Todo todo : todos) {
            System.out.println(todo.getName());
            System.out.println(todo.getCreatedAt());
        }
    }

    @Test
    public void updateByPrimaryKey() {
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void selectState() {
    }
}