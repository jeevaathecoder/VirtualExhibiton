package com.virtualexhibiton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtualexhibiton.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
  @Query("select ur from user_roles  ur WHERE ur.user_role = :userRole")
  UserRole findByUserRole(@Param("userRole") String userRole);
  
}
