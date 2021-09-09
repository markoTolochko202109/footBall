package com.markoTolochko.footBallManager.footBallManagerApp.dao;

import com.markoTolochko.footBallManager.footBallManagerApp.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
