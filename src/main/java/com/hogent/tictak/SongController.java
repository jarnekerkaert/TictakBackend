package com.hogent.tictak;

import com.hogent.tictak.exception.ResourceNotFoundException;
import com.hogent.tictak.model.RegisterModel;
import com.hogent.tictak.model.Song;
import com.hogent.tictak.model.User;
import com.hogent.tictak.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
class SongController {

    private final SongService songService;
    private final UserService userService;

    @Autowired
    public SongController(SongService songService, UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    List<Song> getSongs() {
        log.info("GET ALL songs");
        return songService.findAll();
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
    Song findSongById(@PathVariable("id") String id) {
        log.info("GET song by id: {}", id);
        return songService.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    void addSongByUser(@PathVariable("id") String id, @RequestBody Song song, Authentication authentication) {
        log.info("POST SONG by user with id: {}", id);
        userService.findById(id)
                .map(u -> {
                    song.setUserName(u.getName());
                    songService.add(song);
                    u.addSong(song);
                    userService.updateUser(u);
                    return u;
                }).orElseThrow(() -> {
            String errorMessage = String.format("User with id %s not found", id);
            return new ResourceNotFoundException(errorMessage);
        });
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    UserModel register(@RequestBody RegisterModel user, Authentication authentication) {
        log.info("POST user with name: {}", user.getName());
        return convertToUserModel(userService.register(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    UserModel login(Authentication authentication) {
        log.info("LOGIN user with name: {}", authentication.getName());
        return convertToUserModel(userService.findUserByName(authentication.getName()).orElseThrow(ResourceNotFoundException::new));
    }

    private UserModel convertToUserModel(User user) {
        return new UserModel(
                user.getId(),
                user.getName(),
                user.getSongs());
    }
}
