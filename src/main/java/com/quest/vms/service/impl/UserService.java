package com.quest.vms.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.vms.db.dao.IUserDao;
import com.quest.vms.db.entity.User;
import com.quest.vms.dto.common.UserDto;
import com.quest.vms.exception.InternalServerError;
import com.quest.vms.exception.RecordNotFoundException;
import com.quest.vms.service.IUserService;

@Service
public class UserService implements IUserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	IUserDao userDao;

	@Override
	public UserDto create(UserDto userDto) throws InternalServerError {

		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDto, User.class);
//		User user = new User();
//		user.setFirstName(userDto.getFirstName());
//		user.setLastName(userDto.getLastName());
//		user.setEmail(userDto.getEmail());
//		user.setContactNo(userDto.getContactNo());
//		user.setIdProof(userDto.getIdProof());
//		user.setVisitorType(userDto.getVisitorType());
//		user.setReasonForVisit(userDto.getReasonForVisit());
//		user.setContactPerson(userDto.getContactPerson());
//		user.setTimeSlot(userDto.getTimeSlot());
//		user.setDevice(userDto.getDevice());

		if (userDao.save(user) == null)
			throw new InternalServerError("Error While saving data");

		return userDto;
	}

	@Override
	public UserDto getUserById(long id) throws RecordNotFoundException {

		User user = userDao.getUserById(id);
		if (user == null)
			throw new RecordNotFoundException("Record not found with given ID");

		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(user, UserDto.class);

//		UserDto userDto = new UserDto();
//		userDto.setFirstName(user.getFirstName());
//		userDto.setLastName(user.getLastName());
//		userDto.setEmail(user.getEmail());
//		userDto.setContactNo(user.getContactNo());
//		userDto.setIdProof(user.getIdProof());
//		userDto.setVisitorType(user.getVisitorType());
//		userDto.setReasonForVisit(user.getReasonForVisit());
//		userDto.setContactPerson(user.getContactPerson());
//		userDto.setTimeSlot(user.getTimeSlot());
//		userDto.setDevice(user.getDevice());

		return userDto;
	}

	@Override
	public void delete(long id) throws RecordNotFoundException {
		User userToBeDeleted = null;

		userToBeDeleted = userDao.getUserById(id);

		if (userToBeDeleted == null)
			throw new RecordNotFoundException("Record not found with id: " + id);

		userDao.delete(userToBeDeleted);
	}

}
