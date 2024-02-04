//package com.virtualexhibiton.services;
//
//import com.virtualexhibiton.constants.VirtualexhibitionConstants;
//import com.virtualexhibiton.model.User;
//import com.virtualexhibiton.model.UserRole;
//import com.virtualexhibiton.repository.UserRepository;
//import com.virtualexhibiton.request.SignupRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    
//    @Autowired
//    private UserRoleService userRoleservice;
//    
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void registerUser(SignupRequest signUpRequest) {
//        String email = signUpRequest.getEmail();
//        String role =null;
//        // Check if the username or email is already taken
//        if (userRepository.existsByEmail(email)) {
//            throw new RuntimeException("Username is already taken!");
//        }
//
//        if (userRepository.existsByEmail(email)) {
//            throw new RuntimeException("Email is already in use!");
//        }
//        // Create new user's account
//        User user = new User();
//        user.setEmail(signUpRequest.getEmail());
//        user.setFirstname(signUpRequest.getFirstname());
//        user.setLastname(signUpRequest.getLastname());
//        user.setMobile(signUpRequest.getMobile());
//        user.setProfile(signUpRequest.getProfile());
//        user.setStatus(VirtualexhibitionConstants.UNAUTHORIZED_USER);
//        user.setUser_type_id(signUpRequest.getUser_type_id());
//        userRepository.save(user);
//    }
//
//	public UserRole get(Long user_type_id) {
//		UserRole  user_role =userRoleservice.findRoleById(user_type_id);
//		return user_role;
//	}
//
//
//}
