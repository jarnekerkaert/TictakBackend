package com.hogent.tictak.user;

import com.hogent.tictak.exception.ResourceNotFoundException;
import com.hogent.tictak.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    User register(@RequestBody RegisterModel user) {
        log.info("POST user with name: {}", user.getName());
        return userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    User login(Authentication authentication) {
        log.info("LOGIN user with name: {}", authentication.getName());
        return userService.findUserByName(authentication.getName()).orElseThrow(ResourceNotFoundException::new);
    }
}
