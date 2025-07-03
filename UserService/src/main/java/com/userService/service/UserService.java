package com.userService.service;

import com.userService.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> listAllUser();

    User userFindIdBy(long id);

    void deleteUserById(long id);

    User updateUserId(User user, long id);

    User partialUpdateUser(User partialUser, long id);
}
