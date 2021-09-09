package com.markoTolochko.footBallManager.footBallManagerApp.controller;

import com.markoTolochko.footBallManager.footBallManagerApp.entity.Player;
import com.markoTolochko.footBallManager.footBallManagerApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return managerService.getAllPlayers();
    }
    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return managerService.getPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        managerService.addPlayer(player);
        return player;
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id){
        return managerService.updatePlayer(id);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id){
        managerService.deletePlayer(id);
    }

}
