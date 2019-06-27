package com.libs.sys.Dao;
import org.springframework.stereotype.Repository;
import com.libs.sys.Entity.User;

@Repository
public interface UserDao {
	public abstract int addUser(User user);
	public abstract User fetchUserbyID(int id);
	public abstract void updateUser(User s);
	public abstract void deleteUserID(int id);
	public abstract User getUser(int roll, String password);
	public abstract User fetchUserbyRoll(int roll);
}
