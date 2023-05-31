package com.company.service;

import com.company.model.Content;
import com.company.model.Podcast;
import com.company.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ContentService {

    List<Content> contentList;
    List<Song> songList;
    List<Podcast> podcastList;

    public ContentService() {
        this.contentList = new ArrayList<>();
        this.songList = new ArrayList<>();
        this.podcastList = new ArrayList<>();
    }

    public void addSongToList(String name,
                              String artist,
                              String genre,
                              Integer duration,
                              Integer releaseYear,
                              String album){
        Song song = new Song(name,
                artist,
                genre,
                duration,
                releaseYear,
                album);

        contentList.add(song);

    }

    public List<Song> getSongList() {
        return songList;
    }

    public List<Podcast> getPodcastList() {
        return podcastList;
    }
}
