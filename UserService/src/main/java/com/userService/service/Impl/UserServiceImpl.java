package com.userService.service.Impl;

import com.userService.ResourceNotFoundException.ResourceNotFoundException;
import com.userService.entity.User;
import com.userService.repository.UserRepository;
import com.userService.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        User userEntity = mapToEntity(user);
        User newUser = userRepository.save(userEntity);
        return newUser;
    }

    @Override
    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToEntity(user)).collect(Collectors.toList());
    }

    @Override
    public User userFindIdBy(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );
        return mapToEntity(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );

        userRepository.delete(user);
    }

    @Override
    public User updateUserId(User user, long id) {
        User users = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );

        users .setName(user.getName());
        users.setEmail(user.getEmail());
        users.setAbout(user.getAbout());

        User user1 = userRepository.save(users);

        return user1;
    }

    @Override
    public User partialUpdateUser(User partialUser, long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );

        // Update only non-null fields
        if (partialUser.getName() != null) {
            existingUser.setName(partialUser.getName());
        }
        if (partialUser.getEmail() != null) {
            existingUser.setEmail(partialUser.getEmail());
        }
        if (partialUser.getAbout() != null) {
            existingUser.setAbout(partialUser.getAbout());
        }

        // Save the updated user
        User updatedUser = userRepository.save(existingUser);

        return mapToEntity(updatedUser);
    }


    private User mapToEntity(User user) {
        return mapper.map(user, User.class);
    }
}
