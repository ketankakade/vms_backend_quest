package com.quest.vms.service.impl;

import java.sql.Timestamp;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quest.vms.common.utils.ErrorCodes;
import com.quest.vms.common.utils.GenericResponse;
import com.quest.vms.common.utils.PassCodeGenerator;
import com.quest.vms.common.utils.VmsConstants;
import com.quest.vms.db.dao.IdentityDAO;
import com.quest.vms.db.entity.UserIdentity;
import com.quest.vms.db.repository.IdentityRepository;
import com.quest.vms.dto.common.UserIdentityDTO;
import com.quest.vms.dto.req.SignInReq;
import com.quest.vms.dto.req.UserSignup;
import com.quest.vms.dto.res.SignInRes;
import com.quest.vms.dto.res.SignUpRes;
import com.quest.vms.service.IdentityService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IdentityServiceImpl implements IdentityService {

	@Autowired
	private IdentityDAO userIdentityDAO;
	@Autowired
	private IdentityRepository userIdentityRepository;
	@Autowired
	private PassCodeGenerator passcodeGenerate;

	@Override
	public GenericResponse<SignUpRes> signUpUser(UserSignup dto) {
		SignUpRes res = new SignUpRes();
		GenericResponse<SignUpRes> genericRes = new GenericResponse<SignUpRes>();
		String nonce = passcodeGenerate.createNonce();
		String password = dto.getPassword();
		String securePasscode = passcodeGenerate.generateSecurePassword(password, nonce);
		UserIdentityDTO userDTO = UserIdentityDTO.builder().email(dto.getEmail()).firstName(dto.getFirstName())
				.lastName(dto.getLastName()).mobileNumber(dto.getLastName()).nonce(nonce).saltedHash(securePasscode)
				.build();
		UserIdentityDTO userDTO2 = userIdentityDAO.saveUser(userDTO);
		if (userDTO2 != null) {
			res.setNonce(nonce);
			res.setUserId(userDTO.getEmail());
			genericRes.setMessageCode(HttpStatus.OK.value());
			genericRes.setMessage("SignUp Success");
			genericRes.setData(Collections.singletonList(res));
		}
		return genericRes;
	}

	@Override
	public GenericResponse<SignInRes> signInUser(SignInReq dto) {
		log.info("sign in user");
		GenericResponse<SignInRes> stringGenericRes = new GenericResponse<>(ErrorCodes.BAD_REQUEST_STATUS_CODE,
				VmsConstants.SIGN_IN_FAILED_MESSAGE, null, null);
		UserIdentity user = userIdentityRepository.findByEmailIgnoreCase(dto.getEmail());
		if (user != null) {
			if (dto.getPassword().equals(user.getSaltedHash())) {
				Timestamp lastSignIn = user.getLastSignIn();
				user.setLastSignIn(new Timestamp(System.currentTimeMillis()));
				userIdentityRepository.save(user);
				if (lastSignIn != null) {
					stringGenericRes.setData(Collections.singletonList(new SignInRes(lastSignIn)));
				}
				stringGenericRes.setMessage(VmsConstants.SUCCESS_MESSAGE);
				stringGenericRes.setMessageCode(HttpStatus.OK.value());
			} else
				stringGenericRes.setMessage(VmsConstants.SIGN_IN_FAILED_MESSAGE);
		} else
			stringGenericRes.setMessage("Email id is invalid");
		return stringGenericRes;
	}

}
