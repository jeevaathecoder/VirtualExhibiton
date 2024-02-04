package com.virtualexhibiton.services;

import com.virtualexhibiton.model.User;
import com.virtualexhibiton.request.SignupRequest;
import com.virtualexhibiton.request.UserRequest;

import jakarta.validation.Valid;

public interface IUserService {

	User createUser(@Valid SignupRequest request);

	String authorize(@Valid UserRequest request);

	User findByUserId(Long id);

}
