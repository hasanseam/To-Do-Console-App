package com.hasanur.ToDo.dao;

import com.hasanur.ToDo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        // Use parameterized query to avoid SQL injection
        List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        // Check if any user found with the given email
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null; // Return null if no user found
        }
    }

    @Override
    public void addUser(User user) {
        //save user data
        entityManager.persist(user);
    }
}
