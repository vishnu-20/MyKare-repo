package com.myKare.Service;

import java.util.List;

import com.myKare.Exception.UserException;
import com.myKare.model.LoginData;
import com.myKare.model.User;

public interface UserService {

	public String authenticate(LoginData data) throws UserException;
	public String addUser(User user);
	
	public List<User> getAllUser() throws UserException;
	public String deleteCustomer(String email) throws UserException;
}
