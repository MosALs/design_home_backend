package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.Entity.Governorates;
import com.home.Entity.Ranking;

@Service
public interface RankingService {

	void save(Ranking ranking);

	public Ranking Modify(int id);

	Ranking delete(int id);

	List<Ranking> getAllGovernorates();

	List<Ranking> searchRankingByrank(String rank);
}
