package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.Entity.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {

}
