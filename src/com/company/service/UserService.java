package com.company.service;

import com.company.model.Client;
import com.company.model.Content;
import com.company.model.PremiumClient;
import com.company.model.StandardClient;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<PremiumClient> premiumClientList;
    List<StandardClient> standardClientList;

    public UserService() {
        premiumClientList = new ArrayList<>();
        standardClientList = new ArrayList<>();
    }

    public void addSongToPlaylist(Content content, Long userId) {
        Client client = buscarUsuarioPorId(userId);

        if (client == null) {
            throw  new IllegalArgumentException();
        }

        client.addContentToPlayList(content, 0L);

    }

    public Client buscarUsuarioPorId(Long userId) {

        return standardClientList.stream()
                .filter(client -> client.getId().equals(userId) )
                .findFirst()
                .orElse(null);
    }



}
