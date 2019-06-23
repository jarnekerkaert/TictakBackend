package com.hogent.tictak.user;

import com.hogent.tictak.exception.UserAlreadyExistsException;
import com.hogent.tictak.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
class UserService {

    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository) {
        this.repository = repository;
    }

    User register(RegisterModel user) {
        if(!repository.findUserByName(user.getName()).isPresent()) {
            User newUser =  new User(UUID.randomUUID().toString(), user.getName(), user.getPassword(), Collections.emptyList());
            return repository.save(newUser);
        }
        else {
            throw new UserAlreadyExistsException(user.getName());
        }
    }

    Optional<User> login(LoginModel user) {
        return repository.findUserByName(user.getName());
    }
}
