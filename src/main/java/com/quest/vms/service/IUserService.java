package com.quest.vms.service;

import com.quest.vms.dto.common.UserDto;
import com.quest.vms.exception.InternalServerError;
import com.quest.vms.exception.RecordNotFoundException;

public interface IUserService {

	public UserDto create(UserDto user) throws InternalServerError;
	public UserDto getUserById(long id) throws RecordNotFoundException;
	public void delete(long id) throws RecordNotFoundException;
}
