package com.libs.sys.Service;

import org.springframework.stereotype.Service;

import com.libs.sys.Entity.User;

@Service
public interface UserService {
	 public abstract int createUser(User user);
	 public abstract User getUserbyID(int id);
	 public abstract void updateUser(User s);
	 public abstract void deleteUserID(int id);
	public abstract User login(int i, String password);
	public abstract User getUserbyRoll(int roll);

	

}
