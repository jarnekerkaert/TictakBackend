package com.hogent.tictak;

import org.springframework.data.annotation.Id;

import java.util.List;

class Song {
    @Id
    private Long id;
    private String title;
    private Note key;
    private List<Note> chords;

    Song(Long id, String title, Note key, List<Note> chords) {
        this.id = id;
        this.title = title;
        this.key = key;
        this.chords = chords;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    Note getKey() {
        return key;
    }

    void setKey(Note key) {
        this.key = key;
    }

    List<Note> getChords() {
        return chords;
    }

    void setChords(List<Note> chords) {
        this.chords = chords;
    }
}
