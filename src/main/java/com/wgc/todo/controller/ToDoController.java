package com.wgc.todo.controller;

import com.wgc.todo.entity.Todo;
import com.wgc.todo.exception.DatabaseException;
import com.wgc.todo.exception.DateValidateException;
import com.wgc.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@CrossOrigin
public class ToDoController {
    @Autowired
    private ToDoService service;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Todo> selectAll() {
        List<Todo> todos = null;
        try {
            todos = service.selectAll();
        } catch (DatabaseException e) {
            todos = null;
            return todos;
        } catch (Exception e) {
            todos = null;
            return todos;
        }
        return todos;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void insert(@RequestBody Todo todo, HttpServletResponse response) {
        try {
            /*response.setHeader("Access-Control-Allow-Methods", "http://localhost:8081/");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");*/
            service.insert(todo);
        } catch (DateValidateException e) {
            e.getMessage();
        } catch (Exception e) {
            return;
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id")  int id) {
        try {
            service.deleteByPrimaryKey(id);
        } catch (DateValidateException e) {
            e.getMessage();
        } catch (Exception e) {
            return;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(Todo todo) {
        if (todo != null) {
            service.updateByPrimaryKey(todo);
        }
    }


    @PostMapping(value = "/state")
    public void updateState(@RequestBody Todo todo) {
        if (todo.getState() == null) {
            return;
        }
        todo.setState("已完成");
        service.updateState(todo.getState(), todo.getId());
    }
}
