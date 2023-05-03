package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Song  extends Content {


    private String artist;
    private String genre;
    private String album;
    private Integer releaseYear;





    public Song(
                String name,
                String artist,
                String genre,
                Integer duration,
                Integer releaseYear,
                String album) {

        super(name,duration);
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;



    }

    public Song(
            String name,
            String artist,
            String genre,
            Integer duration,
            Integer releaseYear,
            String album,
            Producer producer) {

        super(name,duration);
        this.artist = artist;
        this.genre = genre;

        this.releaseYear = releaseYear;
        this.album = album;


        this.producers.add(producer);
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /*
    public String getName() {
        return name;
    }
    */


    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public  Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getNumberOfDownloads() {
        return numberOfDownloads;
    }



    public void setNumberOfDownloads(Integer numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", duration=" + duration + ", album=" + album + ", numberOfDownloads=" + numberOfDownloads + '}'
                + "\nProducers: " + producers;
    }

    public void play(){
        System.out.println("Playing song "+ this.name);
    }
}
