package dao;

import java.util.List;

import model.UserDetail;

public interface UserDAO {
	
	public boolean registerUser(UserDetail user);
	public boolean updateUserDetail(UserDetail user);
	public boolean deleteUserDetail(UserDetail user);
	
	public UserDetail validateUser(String userName,String password);
	public UserDetail getUser(String userName);
}
