package com.markoTolochko.footBallManager.footBallManagerApp.controller;

import com.markoTolochko.footBallManager.footBallManagerApp.entity.Team;
import com.markoTolochko.footBallManager.footBallManagerApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/team")
public class TeamController {


    @Autowired
    private ManagerService managerService;

    @GetMapping("/teams")
    public List<Team> showAllTeams(){
        return managerService.getAllTeams();
    }
    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable int id){
        return managerService.getTeam(id);
    }

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team){
        managerService.addTeam(team);
        return team;
    }

    @PutMapping("/teams/{id}")
    public Team updateTeam(@PathVariable int id){
       Team team = managerService.updateTeam(id);
        return team;
    }

    @DeleteMapping("/teams/{id}")
    public void  deleteTeam(@PathVariable int id){
        managerService.deleteTeam(id);
    }
}

