package com.marko.footBallManagerSide.communication;

import com.marko.footBallManagerSide.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Component
public class CommunicationPlayer {

    @Autowired
    private RestTemplate restTemplate;
    private final String URLPLAYER = "http://localhost:8080/player/players";

    public List<Player> getAllPlayers(){
        ResponseEntity<List<Player>> responseEntity = restTemplate.exchange(URLPLAYER, HttpMethod.GET, null, new ParameterizedTypeReference<List<Player>>() {
        });
        List<Player> allPlayers = responseEntity.getBody();
        return allPlayers;
    }

    public Player getPlayer(int id){
        Player player = restTemplate.getForObject(URLPLAYER + "/" + id, Player.class);
        return player;
    }

    public void addPlayer(Player player){
        int playerId = player.getId();

        if (playerId == 0){
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URLPLAYER, player, String.class);
            System.out.println("added to DB");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URLPLAYER, player);
            System.out.println("updated");
        }
    }

    public void deletePlayer(int id){
        restTemplate.delete(URLPLAYER + "/" + id);
        System.out.println("deleted");
    }




}
