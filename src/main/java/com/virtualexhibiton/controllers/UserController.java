package com.virtualexhibiton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualexhibiton.constants.VirtualexhibitionConstants;
import com.virtualexhibiton.model.User;
import com.virtualexhibiton.request.LoginRequest;
import com.virtualexhibiton.request.SignupRequest;
import com.virtualexhibiton.request.UserRequest;
import com.virtualexhibiton.services.IUserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private IUserService userService;
	

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody LoginRequest loginRequest){
		// we have implement such that it has to send token with it.
		return null;
	}
	
	@PostMapping("/createuser")
	public ResponseEntity<?> creatUser(@Valid @RequestBody SignupRequest request){
	  User user	= userService.createUser(request);
	     if(user==null) {
	    	 return ResponseEntity.badRequest().body("emailId is already existed or User already existed");
	     }
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/authorize")
	public ResponseEntity<?> authorize(@Valid @RequestBody UserRequest request){
		String response = userService.authorize(request);
		if(response.equals(VirtualexhibitionConstants.AUTHORIZED_USER)) {
			return ResponseEntity.ok(response);
		}
	 return ResponseEntity.badRequest().body(response);
	}
	
	
}
