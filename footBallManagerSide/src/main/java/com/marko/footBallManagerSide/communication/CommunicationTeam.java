package com.marko.footBallManagerSide.communication;

import com.marko.footBallManagerSide.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class CommunicationTeam {

    @Autowired
    private RestTemplate restTemplate;
    private final String URLTEAM = "http://localhost:8080/team/teams";

    public List<Team> getAllTeams(){
        ResponseEntity<List<Team>> responseEntity = restTemplate.exchange(URLTEAM, HttpMethod.GET, null, new ParameterizedTypeReference<List<Team>>() {
        });
        return  responseEntity.getBody();
    }

    public Team getTeam(int id){
        Team team = restTemplate.getForObject(URLTEAM + "/" + id, Team.class);
        return team;
    }

    public void addTeam(Team team){
        int teamId = team.getId();

        if (teamId == 0){
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URLTEAM, team, String.class);
            System.out.println("added to DB");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URLTEAM, team);
            System.out.println("updated");
        }
    }

    public void deleteTeam(int id){
        restTemplate.delete(URLTEAM + "/" + id);
        System.out.println("deleted");
    }




}
