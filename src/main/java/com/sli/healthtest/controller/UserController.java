package com.sli.healthtest.controller;

import com.sli.healthtest.model.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sli.healthtest.model.User;
import com.sli.healthtest.service.UserService;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author sli
 * @since 2016/10/27
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping
    public ResponseEntity<List<User>> getAll(User user) {
        List<User> userList = userService.getAll(user);
        ResponseEntity<List<User>> responseEntity = new ResponseEntity<>();
        responseEntity.setData(userList);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        ResponseEntity<User> responseEntity = new ResponseEntity<>();
        responseEntity.setData(user);
        return responseEntity;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        ResponseEntity<User> responseEntity = new ResponseEntity<>();
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            responseEntity.setStatus(1101);
        } else {
            userService.add(user);
            responseEntity.setData(user);
        }
        return responseEntity;
    }

}
