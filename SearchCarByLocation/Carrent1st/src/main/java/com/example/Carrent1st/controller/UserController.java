package com.example.Carrent1st.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.Carrent1st.model.User;
import com.example.Carrent1st.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
