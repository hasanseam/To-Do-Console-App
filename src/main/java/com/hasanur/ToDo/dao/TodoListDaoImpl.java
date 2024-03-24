package com.hasanur.ToDo.dao;

import com.hasanur.ToDo.entity.TodoList;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import jakarta.persistence.PersistenceContext;
@Repository
@Transactional
public class TodoListDaoImpl implements TodoListDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TodoList getTodoListById(Integer id) {
        return entityManager.find(TodoList.class, id);
    }

    @Override
    public List<TodoList> getTodoListsByUserId(Integer userId) {
        return entityManager.createQuery("SELECT t FROM TodoList t WHERE t.user.id = :userId", TodoList.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public void addTodoList(TodoList todoList) {
        entityManager.persist(todoList);
    }

    @Override
    public void updateTodoList(TodoList todoList) {
        entityManager.merge(todoList);
    }

    @Override
    public void deleteTodoList(Integer id) {
        TodoList todoList = entityManager.find(TodoList.class, id);
        if (todoList != null) {
            entityManager.remove(todoList);
        }
    }
}
