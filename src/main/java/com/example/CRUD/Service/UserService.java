package com.example.CRUD.Service;

import com.example.CRUD.Models.User;
import com.example.CRUD.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> saveUser(List<User> users){
        return userRepo.saveAll(users);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }
    public User getById(long id){
        return userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public User updateUser(long id, User newUser){
        User user = userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setAge(user.getAge());
        user.setDesignation(user.getDesignation());
        userRepo.save(user);
        return user;
    }

    public String deleteUser(long id){
        userRepo.deleteById(id);
        return "User deleted!!!" + id;
    }

}
