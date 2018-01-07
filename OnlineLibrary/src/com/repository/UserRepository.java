package com.repository;

import java.util.List;

import com.bean.Login;
import com.bean.UserDetails;

public interface UserRepository {

	public abstract void addUserDetails(UserDetails userDetail) throws Exception;
	public abstract void editUserDetails(UserDetails userDetail) throws Exception;
	public abstract UserDetails modifyUserDetails(String userId) throws Exception;
	public abstract void deleteUserDetails(String userId) throws Exception;
	public abstract List<UserDetails> getAllUserDetails() throws Exception;
	public abstract UserDetails validateUserDetails(Login login) throws Exception;

}