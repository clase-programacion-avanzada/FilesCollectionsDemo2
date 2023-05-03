package com.company.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PremiumClient extends Client {

    private final List<PlayList> playLists;

    public PremiumClient(String userName, String password, String name, String lastName, Integer age) {
        super(userName, password, name, lastName, age);
        this.playLists = new ArrayList<PlayList>();
    }


    public List<PlayList> getPlayLists() {
        return playLists;
    }

    @Override
    public boolean addContentToPlayList(Content content, Long playlistId) {
        for (PlayList playList : playLists) {
            if (Objects.equals(playList.getId(), playlistId)) {
                playList.addContent(content);
                return true;
            }
        }
        return false;

    }



}
