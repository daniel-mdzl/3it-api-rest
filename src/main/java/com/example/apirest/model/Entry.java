package com.example.apirest.model;

public class Entry {
    private String genre;
    private Integer count;

    public Entry() {

    }

    public Entry(String genre, Integer count) {
        this.genre = genre;
        this.count = count;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
