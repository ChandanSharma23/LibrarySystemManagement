package com.libs.sys;

import com.libs.sys.Dao.UserDao;
import com.libs.sys.Dao.impl.UserDaoimpl;

public class test {

	public static void main(String[] args) {
	UserDao dao = new UserDaoimpl();
	System.out.println(dao.fetchUserbyID(1));
	}

}
