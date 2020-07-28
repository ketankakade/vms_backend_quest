package com.quest.vms.dto.req;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignup {

	@Size(min = 3, max = 50, message = "firstName must be between 3 and 50 characters")
	@NotBlank(message = "firstName cannot be null or empty")
	private String firstName;

	@Size(min = 3, max = 50, message = "lastName must be between 3 and 50 characters")
	@NotBlank(message = "lastName cannot be null or empty")
	private String lastName;

	@Email(message = "email should be valid")
	@NotBlank(message = "email cannot be null or empty")
	private String email;

	@NotBlank(message = "mobileNumber cannot be null or empty")
	@Size(min = 10, max = 20, message = "Please enter valid mobile number with country code")
	private String mobileNumber;
	
	@NotBlank(message = "password cannot be null or empty")
	private String password;

}
