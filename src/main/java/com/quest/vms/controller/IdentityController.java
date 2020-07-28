package com.quest.vms.controller;

import static com.quest.vms.common.utils.VmsConstants.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.vms.common.utils.GenericResponse;
import com.quest.vms.dto.req.SignInReq;
import com.quest.vms.dto.req.UserSignup;
import com.quest.vms.dto.res.SignInRes;
import com.quest.vms.dto.res.SignUpRes;
import com.quest.vms.exception.ServiceException;
import com.quest.vms.service.IdentityService;

@RestController
@RequestMapping("/" + USER_URL_PATH)
public class IdentityController {

	@Autowired
	private IdentityService userIdentityService;

	@PostMapping(SIGN_UP)
	public ResponseEntity<GenericResponse<SignUpRes>> signUpUser(@Valid @RequestBody UserSignup dto) {
		try {
			GenericResponse<SignUpRes> signUpResGenericRes = userIdentityService.signUpUser(dto);
			return ResponseEntity.status(signUpResGenericRes.getMessageCode()).body(signUpResGenericRes);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping(SIGN_IN)
	public ResponseEntity<GenericResponse<SignInRes>> signInUser(@Valid @RequestBody SignInReq request) {
		try {
			GenericResponse<SignInRes> signInResponse = userIdentityService.signInUser(request);
			return ResponseEntity.status(signInResponse.getMessageCode()).body(signInResponse);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
