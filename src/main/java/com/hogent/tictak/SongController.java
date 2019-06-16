package com.hogent.tictak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    List<Song> getSongs() {
        return songService.findAll();
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
    Song findSong(@PathVariable("id") String id) {
        return songService.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    void add(@RequestBody Song song) {
        songService.add(song);
    }
}
