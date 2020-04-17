package com.home.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Branches;
import com.home.Repository.BranchesRepository;
@Service
public class BranchesServiceImp implements BranchesService{

	@Autowired
	BranchesRepository branchesRepository;
	@Override
	public boolean save(Branches branches) {
		
		return branchesRepository.save(branches)!=null;
	}

}
