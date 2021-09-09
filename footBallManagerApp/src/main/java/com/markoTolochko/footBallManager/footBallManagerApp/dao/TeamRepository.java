package com.markoTolochko.footBallManager.footBallManagerApp.dao;

import com.markoTolochko.footBallManager.footBallManagerApp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
