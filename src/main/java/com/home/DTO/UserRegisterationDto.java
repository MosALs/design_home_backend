package com.home.DTO;

import com.home.Entity.Branches;
import com.home.Entity.Users;

public class UserRegisterationDto {
	
	private Users user;
	private Branches branch ;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Branches getBranch() {
		return branch;
	}
	public void setBranch(Branches branch) {
		this.branch = branch;
	}
	
	
}
