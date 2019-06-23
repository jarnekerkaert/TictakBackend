package com.hogent.tictak.song;


import com.hogent.tictak.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;


interface SongRepository extends MongoRepository<Song, String> {

}
