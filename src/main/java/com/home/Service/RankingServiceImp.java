package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Ranking;
import com.home.Repository.RankingRepository;

@Service
public class RankingServiceImp implements RankingService{

	@Autowired
	private RankingRepository rankingRepository;

	@Override
	public void save(Ranking ranking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ranking Modify(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ranking delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ranking> getAllGovernorates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ranking> searchRankingByrank(String rank) {
		// TODO Auto-generated method stub
		return null;
	}
}
