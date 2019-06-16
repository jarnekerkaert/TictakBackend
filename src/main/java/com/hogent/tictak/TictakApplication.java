package com.hogent.tictak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TictakApplication {

    public static void main(String[] args) {
        SpringApplication.run(TictakApplication.class, args);
    }

}
