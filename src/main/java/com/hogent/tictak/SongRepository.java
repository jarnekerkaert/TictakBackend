package com.hogent.tictak;


import com.hogent.tictak.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;


interface SongRepository extends MongoRepository<Song, String> {

}
