package com.libs.sys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.libs.sys.Dao.UserDao;
import com.libs.sys.Entity.User;

@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
	@Qualifier("userDaoimpl")
	UserDao userDaoimpl;

	@Override
	public int createUser(User user) {
		return userDaoimpl.addUser(user);
	}

	@Override
	public User getUserbyID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(int roll, String password) {
		// TODO Auto-generated method stub
		return userDaoimpl.getUser(roll,password) ;
		
		
	}

	
}
