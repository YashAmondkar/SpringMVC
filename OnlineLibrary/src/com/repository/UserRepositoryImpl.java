package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Login;
import com.bean.UserDetails;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	private final class UserDetailsRowMapper implements RowMapper<UserDetails>{

		@Override
		public UserDetails mapRow(ResultSet rs, int index) throws SQLException {
			
			UserDetails userDetail = new UserDetails();
			userDetail.setUserId(rs.getString("userId"));
			userDetail.setFirstName(rs.getString("firstName"));
			userDetail.setLastName(rs.getString("lastName"));
			userDetail.setEmailId(rs.getString("emailId"));
			userDetail.setCity(rs.getString("city"));
			userDetail.setPhoneNumber(rs.getString("phoneNumber"));
			userDetail.setPassword("************");

			return userDetail;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.repository.UserRepository#addUserDetails(com.bean.UserDetails)
	 */
	@Override
	public void addUserDetails(UserDetails userDetail) throws Exception {
		String queryInsert = "insert into UserDetails(userId,firstName,lastName,emailId,city,phoneNumber,password) values (?,?,?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(queryInsert, userDetail.getUserId(),userDetail.getFirstName(),userDetail.getLastName(),userDetail.getEmailId(),userDetail.getCity(),userDetail.getPhoneNumber(),userDetail.getPassword());
		
		if(rowsAffected != 1){
			throw new Exception("Insertion Failed for query : " + queryInsert);
		}		
	}
	
	/* (non-Javadoc)
	 * @see com.repository.UserRepository#modifyUserDetails()
	 */
	@Override
	public UserDetails modifyUserDetails(String userId) throws Exception{
		String querySelect = "select * from UserDetails where userId = " + userId;
		
		List<UserDetails> userDetail = jdbcTemplate.query(querySelect, new UserDetailsRowMapper());
		
		if(userDetail.isEmpty()) {
			return null;
		}else if (userDetail.size() == 1) {
			return userDetail.get(0);
		}else {
			throw new IncorrectResultSizeDataAccessException("Incorrect Result size", 1);
		}
		
	}
	
	@Override
	public void editUserDetails(UserDetails userDetail) throws Exception {
		
		String queryUpdate = "update UserDetails set firstName = ?,lastName = ?,emailId = ?,city = ?,phoneNumber = ? where userId = ?";
		int rowsAffected = jdbcTemplate.update(queryUpdate, userDetail.getFirstName(),userDetail.getLastName(),userDetail.getEmailId(),userDetail.getCity(),userDetail.getPhoneNumber(),userDetail.getUserId());
		
		if(rowsAffected != 1){
			throw new Exception("Updation Failed for query : " + queryUpdate);
		}		
	}
	
	/* (non-Javadoc)
	 * @see com.repository.UserRepository#getUserDetails()
	 */
	@Override
	public void deleteUserDetails(String userId) throws Exception{
		String queryDelete = "delete from UserDetails where userId = "+ userId;
		int rowsAffected = jdbcTemplate.update(queryDelete);
		
		if(rowsAffected != 1){
			throw new Exception("Deletion Failed for query : " + queryDelete);
		}
	}
	
	@Override
	public List<UserDetails> getAllUserDetails() throws Exception{
		String querySelectAll = "select * from UserDetails";
		
		List<UserDetails> allUserDetails = jdbcTemplate.query(querySelectAll, new UserDetailsRowMapper());
		
		return allUserDetails;
	}

	@Override
	public UserDetails validateUserDetails(Login login) throws Exception {
        
		String querySelect = "select * from UserDetails where userId = " + login.getUserId() + " and password = " + login.getPassword();
				
		List<UserDetails> userDetail = jdbcTemplate.query(querySelect, new UserDetailsRowMapper());
		
		if(userDetail.isEmpty()) {
			return null;
		}else if (userDetail.size() == 1) {
			return userDetail.get(0);
		}else {
			throw new IncorrectResultSizeDataAccessException("Incorrect Result size", 1);
		}
		
	}
	
	

}
