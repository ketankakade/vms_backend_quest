package com.quest.vms.dto.req;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The type Consumer otp request dto. */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInReq {

	@Email(message = "email should be valid")
	@NotBlank(message = "email cannot be null or empty")
	private String email;

	@NotBlank(message = "password cannot be null or empty")
	private String password;
}
