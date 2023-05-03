package com.company.model;

public class StandardClient extends Client {

    private final PlayList playlist;

    public StandardClient(String userName, String password, String name, String lastName, Integer age) {
        super(userName, password, name, lastName, age);

        this.playlist = new PlayList();

    }

    @Override
    public boolean addContentToPlayList(Content content, Long playListId) {
        if (content instanceof Song) {
            this.playlist.addContent(content);
            return true;
        }
        return false;

    }


}
