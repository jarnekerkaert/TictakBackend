package com.hogent.tictak.model;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class User {

    @Id
    private String id;
    private String name;
    private String password;
    private List<Song> songs;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.songs = Collections.emptyList();
    }

    public User(String id, String name, String password, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.songs = songs;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
