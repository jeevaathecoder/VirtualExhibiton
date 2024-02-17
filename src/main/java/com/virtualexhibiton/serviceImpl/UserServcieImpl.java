package com.virtualexhibiton.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualexhibiton.constants.VirtualexhibitionConstants;
import com.virtualexhibiton.model.User;
import com.virtualexhibiton.repository.UserRepository;
import com.virtualexhibiton.repository.UserRoleRepository;
import com.virtualexhibiton.request.SignupRequest;
import com.virtualexhibiton.request.UserRequest;
import com.virtualexhibiton.services.IUserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServcieImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public User createUser(@Valid SignupRequest request) {
		Boolean existsByEmail = userRepository.existsByEmail(request.getEmail());
		if(!existsByEmail) {
		        User user = new User();
		        user.setEmail(request.getEmail());
		        user.setFirstname(request.getFirstname());
		        user.setLastname(request.getLastname());
		        user.setMobile(request.getMobile());
		        user.setProfile(request.getProfile());
		        user.setUser_type_id(request.getUser_type_id());
		        user.setPassword(request.getPassword());
		        user.setStatus(VirtualexhibitionConstants.UNAUTHORIZED_USER);
		        User create_user = userRepository.save(user);
		        return create_user;
		}
		return null;
	}

	@Override
	public String authorize(@Valid UserRequest request) {
	 Optional<User> adminexisted = userRepository.findById(request.getAdmin_user_id());
	  if(adminexisted.isPresent()&&adminexisted.get()!=null) {
		  String role = userRoleRepository.getRoleById(adminexisted.get().getUser_type_id());
		  Optional<User> isEXHIBITOR = userRepository.findById(request.getUserId());
		  User validUser = isEXHIBITOR.get();
		  String roleofUser = userRoleRepository.getRoleById(validUser.getUser_type_id());
		   if(role==null) {
			   return "ADMIN ID ENTERED WAS INCORRECT";
		   }
		   else if(role.equals(VirtualexhibitionConstants.EXHIBITOR)||role.equals(VirtualexhibitionConstants.USER)) {
			   return "ENTER ID IS USER OR EXHIBITOR";
		   }
		   else if(isEXHIBITOR==null) {
			   return VirtualexhibitionConstants.INVALID_USER;
		   }
		   else if(roleofUser.equals(VirtualexhibitionConstants.USER)) {
			   return VirtualexhibitionConstants.IS_USER;
		   }
		   else {
			   validUser.setStatus(VirtualexhibitionConstants.AUTHORIZED_USER);
			   userRepository.save(validUser);
			   return VirtualexhibitionConstants.USER_AUTHORIZED;
		   }
		   
	  }
		return VirtualexhibitionConstants.ADMIN_DOESNT_EXISTED;
	}

	@Override
	public User findByUserId(Long id) {
		return userRepository.findById(id).get();
	}

}
