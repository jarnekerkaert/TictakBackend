package com.hogent.tictak.song;

import com.hogent.tictak.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SongService {

    private final SongRepository repository;

    @Autowired
    SongService(SongRepository repository) {
        this.repository = repository;
    }

    List<Song> findAll() {
        return repository.findAll();
    }

    void add(Song song) {
        repository.save(song);
    }

    Optional<Song> findById(String id) {
        return repository.findById(id);
    }
}
