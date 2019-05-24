package hu.flowacademy.badge.service;

import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.exception.UserNotFoundException;
import hu.flowacademy.badge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save (User user) {
        if(userRepository.findById(user.getUserName()).isEmpty()) {
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException(user.getUserName());
        }
        /*List<User> userList = userRepository.findByUserNameIn(user.getUserName());
        if(userList == null || userList.isEmpty()) {
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException(user.getUserName());
        }*/
    }

    public void delete (String userName) {
        try {
            userRepository.deleteUserByUserName(userName);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(userName);
        }
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User getOneUser(String userName) {
        if (userRepository.findById(userName).isPresent()) {
            return userRepository.findById(userName).get();
        }
        throw new UserNotFoundException(userName);
    }
}
