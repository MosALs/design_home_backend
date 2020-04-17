package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.home.DTO.SearchResultDTO;
import com.home.DTO.UserRegisterationDto;
import com.home.Entity.Branches;
import com.home.Entity.Specialization;
import com.home.Entity.Users;
import com.home.Repository.BranchesRepository;
import com.home.Repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	BranchesRepository branchesRepository;
	AreasService areasService;

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ModifyName(String newUserName, String oldUserName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ModifyArea(String newAreaName, String oldAreaName) {
		return areasService.Modify(newAreaName, oldAreaName);

	}

	@Override
	public int ModifyCountry(String newcountryName, String oldcountryName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SearchResultDTO> search(String areaName, String accountType, String specializationName) {

		return usersRepository.search(areaName, accountType, specializationName);
	}

	@Override
	public ResponseEntity<?> login(String userData, String password) {
		String userName = null;
		String userMobile = null;
		String paasword = null;
		Users user = null;

		if (userData.startsWith("01")) {
			System.out.println("if 1");
			userMobile = userData;
			user = usersRepository.findByUserMobileAndPassword(userMobile, password);
		} else if (userData.contains("@")) {
			System.out.println("if 2");
			userName = userData;
			user = usersRepository.findByUserNameAndPassword(userName, password);
		}

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "incorrect username or password");
		}

	}

	@Override
	public ResponseEntity<?> save(UserRegisterationDto userDto) {

		Branches branch = userDto.getBranch();
		System.out.println("branch ===== " + branch.toString());

		Users user = userDto.getUser();
		user = usersRepository.save(user);

		if (user != null) {

			branch.setUserId(user);
			System.out.println("user id:===" + user.getId());
			branchesRepository.save(branch);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}

		else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "user is not saved successfully");
		}

	}

}
