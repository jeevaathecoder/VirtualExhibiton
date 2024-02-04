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
  @Query("select ur.user_role from user_roles  ur WHERE ur.id = :user_type_id")
  String getRoleById(@Param("user_type_id") Long user_type_id);
  
}
