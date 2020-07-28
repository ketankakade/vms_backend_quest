package com.quest.vms.service;

import com.quest.vms.common.utils.GenericResponse;
import com.quest.vms.dto.req.SignInReq;
import com.quest.vms.dto.req.UserSignup;
import com.quest.vms.dto.res.SignInRes;
import com.quest.vms.dto.res.SignUpRes;

public interface IdentityService {
	
	GenericResponse<SignUpRes> signUpUser(UserSignup dto);
	
	GenericResponse<SignInRes> signInUser(SignInReq dto);
}
