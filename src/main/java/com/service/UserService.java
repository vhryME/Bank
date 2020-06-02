package com.service;


import com.model.User;
import com.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createUser(User user) {
        if(userRepo != null && !userRepo.existsById(user.getId()) && user != null)
            userRepo.save(user);
    }


    public void deleteUser(User user) {
        if(userRepo != null && userRepo.existsById(user.getId()) && user != null)
            userRepo.delete(user);
    }


    public User getUserByName(String name) {
        if(userRepo != null && userRepo.getByName(name) != null)
            return userRepo.getByName(name);

        return null;
    }


    public List<User> getAllUsers() {
        if(userRepo != null)
            return userRepo.findAll();

        return null;
    }
}
