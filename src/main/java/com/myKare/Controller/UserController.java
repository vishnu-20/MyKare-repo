package com.myKare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myKare.Exception.UserException;
import com.myKare.Service.UserService;
import com.myKare.model.LoginData;
import com.myKare.model.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllEmployee() throws UserException {

		List<User> user = userService.getAllUser();

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);

	}
	
	@GetMapping("/ok")
	public String get() {
		return "ok";
	}

	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		String response = userService.addUser(user);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> delete(@PathVariable String email) throws UserException {

		String response = userService.deleteCustomer(email);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);

	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<String> getEmployee(@RequestBody LoginData loginData) throws UserException  {

		String response = userService.authenticate(loginData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
