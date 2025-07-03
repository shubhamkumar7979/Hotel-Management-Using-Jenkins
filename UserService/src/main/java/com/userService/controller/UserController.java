package com.userService.controller;

import com.userService.entity.User;
import com.userService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    //http://localhost:8081/users

        @PostMapping
                public ResponseEntity<User> createUser (@RequestBody User user){
            User user1 = userService.createUser(user);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //http://localhost:8081/users

    @GetMapping
    public List<User> listAllUser(){
        return userService.listAllUser();
    }

    //http://localhost:8081/users/{id}

    @GetMapping("/{id}")
    public ResponseEntity<User> userFindIdBy(@PathVariable("id") long id){
        User users = userService.userFindIdBy(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    //http://localhost:8081/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable ("id") long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("User id is deleted", HttpStatus.OK);
    }


    //http://localhost:8081/users/{id}

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserId(@RequestBody User user,
                                             @PathVariable ("id") long id){
        User users = userService.updateUserId(user, id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


   // http://localhost:8081/users/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<User> partialUpdateUser(
            @RequestBody User partialUser,
            @PathVariable("id") long id) {
        User updatedUser = userService.partialUpdateUser(partialUser, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
