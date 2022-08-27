package com.myKare.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myKare.Exception.UserException;
import com.myKare.Repository.UserRepository;
import com.myKare.model.LoginData;
import com.myKare.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String addUser(User user) {

		User userEntity = userRepository.findByEmail(user.getEmail());

		if (!Objects.nonNull(userEntity)) {

			return Objects.nonNull(userRepository.save(user)) ? "User saved Successfully"
					: "Something went wrong please contact support";

		}

		return "User with the email : " + user.getEmail() + " already exists";
	}

	@Override
	public String authenticate(LoginData loginData) throws UserException {
		User userEntity = userRepository.findByEmail(loginData.getEmail());

		if (Objects.nonNull(userEntity) && loginData.getPassword().equalsIgnoreCase(userEntity.getPassword())) {
			return "Authentication successfull";
		}

		throw new UserException("UNAUTHORIZED");
	}

	@Override
	public List<User> getAllUser() throws UserException {

		return userRepository.findAll();
	}

	@Override
	public String deleteCustomer(String email) throws UserException {
		User userEntity = userRepository.findByEmail(email);
		userRepository.delete(userEntity);
		return "Deleted";
	}

}
