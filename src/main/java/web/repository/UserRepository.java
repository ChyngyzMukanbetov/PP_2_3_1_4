package web.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> allUsers() {
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return resultList;
    }

    @Transactional
    public void save(User user) {
        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }

    @Transactional
    public void update(User user) {
        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }

    @Transactional
    public void delete(User user) {
        User managed = entityManager.merge(user);
        entityManager.remove(managed);
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

}
