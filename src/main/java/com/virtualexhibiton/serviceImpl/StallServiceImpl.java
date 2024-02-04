package com.virtualexhibiton.serviceImpl;

import com.virtualexhibiton.constants.VirtualexhibitionConstants;
import com.virtualexhibiton.model.Stall;
import com.virtualexhibiton.model.User;
import com.virtualexhibiton.model.UserRole;
import com.virtualexhibiton.repository.StallRepository;
import com.virtualexhibiton.repository.UserRepository;
import com.virtualexhibiton.response.StallResponse;
import com.virtualexhibiton.services.IUserService;
import com.virtualexhibiton.services.StallService;
import com.virtualexhibiton.services.UserRoleService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@Service
public class StallServiceImpl implements StallService {

	@Autowired
	private StallRepository stallRepository;
	
	@Autowired
	private UserRoleService userRoleServcie;
	
	@Autowired
	private IUserService  userService;

	@Override
	public StallResponse saveStall(@Valid Stall stall) {
		UserRole roleExists =null;
		Stall isStallExisted = stallRepository.findByRoleId(stall.getUser().getId());
		User user = userService.findByUserId(stall.getUser().getId());
		if(user!=null) {
			roleExists = userRoleServcie.findRoleById(user.getUser_type_id());
			if(roleExists==null) {
				return StallResponse.builder().responseMessage("ROLE DOESN'T EXISTS").build();
			}
			else if(roleExists!=null&&roleExists.getUser_role().equals(VirtualexhibitionConstants.USER)) {
				return StallResponse.builder().responseMessage("INVALID IS EXHIBITOIR ID").build();
			}
			else if(roleExists!=null&&user.getStatus().equals(VirtualexhibitionConstants.UNAUTHORIZED_USER)) {
				return StallResponse.builder().responseMessage("PLEASE GET APPRVOAL FROM ADMIN TO CREATE STALL").build();
			}
			else if(isStallExisted!=null) {
				return StallResponse.builder().responseMessage("EXHIBITOR HAS STALL ALREADY").build();
			}
			else {
				Stall save = stallRepository.save(stall);
				return StallResponse.builder().responseMessage("SUCCESSFULLY STALL CREATED").stall(stall).build();
			}
		}   
		 return StallResponse.builder().responseMessage("EXHIBITOR DOESN'T EXIST").build();
	}

	@Override
	public List<Stall> fetchStallList() {
		return stallRepository.findAll();
	}

	@Override
	public Stall fetchStallById(Long stallId) {
		return stallRepository.findById(stallId).get();
	}

	@Override
	public void deleteStallById(Long stallId) {
		  stallRepository.deleteById(stallId);
	}

	@Override
	public Stall updateStall(Long stallId, Stall stall) {
		// TODO Auto-generated method stub
		return null;
	}

}
