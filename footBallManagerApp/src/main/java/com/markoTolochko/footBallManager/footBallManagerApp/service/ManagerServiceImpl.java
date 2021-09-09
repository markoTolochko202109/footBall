package com.markoTolochko.footBallManager.footBallManagerApp.service;

import com.markoTolochko.footBallManager.footBallManagerApp.dao.PlayerRepository;
import com.markoTolochko.footBallManager.footBallManagerApp.dao.TeamRepository;
import com.markoTolochko.footBallManager.footBallManagerApp.entity.Player;
import com.markoTolochko.footBallManager.footBallManagerApp.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {


    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeam(int id) {
        return teamRepository.getById(id);
    }

    @Override
    public void addTeam(Team team){
        teamRepository.save(team);
    }

    @Override
    public Team updateTeam(int id) {
        Team team = null;
       Optional<Team>optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            team = optionalTeam.get();
            team = teamRepository.save(team);

        }
       return team;
    }

    @Override
    public void deleteTeam(int id) {
       teamRepository.deleteById(id);
    }



    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(int id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()){
            return playerOptional.get();
        }
        else {
          return null;
        }

    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(int id) {
        Player player = null;
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()){
            player = playerOptional.get();
            player = playerRepository.save(player);
        }
        return player;
    }

    @Override
    public void deletePlayer(int id) {
       playerRepository.deleteById(id);
    }
}
