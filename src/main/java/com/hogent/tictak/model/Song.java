package com.hogent.tictak.model;

import org.springframework.data.annotation.Id;
import java.util.List;

public class Song {

    @Id
    private String id;
    private String user;
    private String title;
    private Note key;
    private List<Note> chords;

    public Song(String id, String user, String title, Note key, List<Note> chords) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.key = key;
        this.chords = chords;
    }

    public Song() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Note getKey() {
        return key;
    }

    public void setKey(Note key) {
        this.key = key;
    }

    public List<Note> getChords() {
        return chords;
    }

    public void setChords(List<Note> chords) {
        this.chords = chords;
    }
}
