package com.hasanur.ToDo.dao;

import com.hasanur.ToDo.entity.TodoList;

import java.util.List;

public interface TodoListDao {
    TodoList getTodoListById(Integer id);
    List<TodoList> getTodoListsByUserId(Integer userId);
    void addTodoList(TodoList todoList);
    void updateTodoList(TodoList todoList);
    void deleteTodoList(Integer id);
}

