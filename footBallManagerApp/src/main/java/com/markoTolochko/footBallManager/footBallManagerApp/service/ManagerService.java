package com.markoTolochko.footBallManager.footBallManagerApp.service;

import com.markoTolochko.footBallManager.footBallManagerApp.entity.Player;
import com.markoTolochko.footBallManager.footBallManagerApp.entity.Team;
import java.util.List;

public interface ManagerService {

    public List<Team> getAllTeams();
    public Team getTeam(int id);
    public void addTeam(Team team);
    public Team updateTeam(int id);
    public void deleteTeam(int id);

    public List<Player> getAllPlayers();
    public Player getPlayer(int id);
    public void addPlayer(Player player);
    public Player updatePlayer(int id);
    public void deletePlayer(int id);
}
