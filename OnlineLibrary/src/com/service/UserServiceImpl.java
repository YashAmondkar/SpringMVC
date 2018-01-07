package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.bean.UserDetails;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
		
	/* (non-Javadoc)
	 * @see com.service.UserService#addUserDetails(com.bean.UserDetails)
	 */
	@Override
	public void addUserDetails(UserDetails userDetail) throws Exception{
		userRepository.addUserDetails(userDetail);
	}
	
	@Override
	public void editUserDetails(UserDetails userDetail) throws Exception{
		userRepository.editUserDetails(userDetail);
	}
	
	/* (non-Javadoc)
	 * @see com.service.UserService#modifyUserDetails()
	 */
	@Override
	public UserDetails modifyUserDetails(String userId) throws Exception{
		return userRepository.modifyUserDetails(userId);
	}
	
	/* (non-Javadoc)
	 * @see com.service.UserService#getUserDetails()
	 */
	@Override
	public void deleteUserDetails(String userId) throws Exception{
		 userRepository.deleteUserDetails(userId);
	}
	
	@Override
	public List<UserDetails> getAllUserDetails() throws Exception{
		return (userRepository.getAllUserDetails());
	}

	@Override
	public UserDetails validateUserDetails(Login login) throws Exception {
		return userRepository.validateUserDetails(login);
	}
		
}
