package com.hogent.tictak;

import com.hogent.tictak.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByName(String name);
}
