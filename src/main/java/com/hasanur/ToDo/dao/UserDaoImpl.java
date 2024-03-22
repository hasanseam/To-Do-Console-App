package com.hasanur.ToDo.dao;

import com.hasanur.ToDo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User getUserById(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void addUser(User user) {
        //save user data
        entityManager.persist(user);
    }
}
