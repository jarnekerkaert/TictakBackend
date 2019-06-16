package com.hogent.tictak;


import org.springframework.data.mongodb.repository.MongoRepository;


interface SongRepository extends MongoRepository<Song, String> {

}
