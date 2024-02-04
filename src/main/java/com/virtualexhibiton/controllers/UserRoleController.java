package com.virtualexhibiton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualexhibiton.model.UserRole;
import com.virtualexhibiton.services.UserRoleService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/userRoles")
public class UserRoleController {
	
	@Autowired
	private UserRoleService userroleService;
	
	
	@PostMapping("/role")
	public ResponseEntity<UserRole> createRole(@NotNull String role) {
		UserRole user = userroleService.createRole(role);
		if(user==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}

}
