package com.virtualexhibiton.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserRequest {
	
	
	@NotBlank
	@Email
	private String emailId;
	
	@NotBlank
	private Long userId;
	
	@NotBlank
	private Long admin_user_id;
	


}
