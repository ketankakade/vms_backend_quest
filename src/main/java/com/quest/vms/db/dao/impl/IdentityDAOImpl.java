package com.quest.vms.db.dao.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quest.vms.db.dao.IdentityDAO;
import com.quest.vms.db.entity.UserIdentity;
import com.quest.vms.db.repository.IdentityRepository;
import com.quest.vms.dto.common.UserIdentityDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IdentityDAOImpl implements IdentityDAO {

	@Autowired
	private IdentityRepository userRepository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public UserIdentityDTO saveUser(UserIdentityDTO dto) {
		log.info("Save User");
		UserIdentity user = transformDtoToEntity(dto);
		UserIdentity checkUser = userRepository.findByEmailIgnoreCase(dto.getEmail());
		if ((checkUser != null)) {
			if ((!checkUser.getFirstName().equals(user.getFirstName()))
					|| (!checkUser.getLastName().equals(user.getLastName()))
					|| (!checkUser.getMobileNumber().equals(user.getMobileNumber()))) {
				checkUser.setFirstName(user.getFirstName());
				checkUser.setLastName(user.getLastName());
				checkUser.setMobileNumber(user.getMobileNumber());
				checkUser = userRepository.save(checkUser);
			}
		} else {
			user = userRepository.save(user);
		}
		return transformEntityToDto(user);
	}

	public UserIdentity transformDtoToEntity(UserIdentityDTO dto) {
		return modelMapper.map(dto, UserIdentity.class);
	}

	public UserIdentityDTO transformEntityToDto(UserIdentity entity) {
		return modelMapper.map(entity, UserIdentityDTO.class);
	}

}
