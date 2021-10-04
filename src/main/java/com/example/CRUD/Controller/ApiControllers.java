package com.example.CRUD.Controller;

import com.example.CRUD.Models.User;
import com.example.CRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ApiControllers {
    @Autowired
    private UserService service;


    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@RequestBody long id){
        return service.getById(id);

    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        service.saveUser(user);
        return "Saved!!!";
    }

    @PutMapping(value="/update/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        return service.updateUser(id, user);

    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);

    }

}
