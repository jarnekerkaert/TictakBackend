package com.hogent.tictak.song;

import com.hogent.tictak.exception.ResourceNotFoundException;
import com.hogent.tictak.model.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
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
}
