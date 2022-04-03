package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.repository.UserRepository;
import web.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
