package com.virtualexhibiton.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualexhibiton.model.UserRole;
import com.virtualexhibiton.services.UserRoleService;
import com.virtualexhibiton.repository.UserRoleRepository;
import jakarta.validation.constraints.NotNull;

@Service
public class UserRoleserviceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleRepository userroleRepository;

	@Override
	public UserRole createRole(@NotNull String userRole) {
		UserRole user_role = new UserRole();

		UserRole roleexisted = userroleRepository.findByUserRole(userRole);
		 if(roleexisted==null) {
			 UserRole role_created = userroleRepository.save(user_role);
		     return role_created;
		 }
		 return null;
	}

	@Override
	public UserRole get(String role) {
		return userroleRepository.findByUserRole(role);
	}

	@Override
	public UserRole findRoleById(Long user_type_id) {
		 Optional<UserRole> role = userroleRepository.findById(user_type_id);
		return role.get();
	}

}
