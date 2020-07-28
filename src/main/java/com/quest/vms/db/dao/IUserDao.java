package com.quest.vms.db.dao;

import com.quest.vms.db.entity.User;

public interface IUserDao {

	public User save(User user);
	public User getUserById(long id);
	//public User update(int id, User user) throws InternalServerError;
	public void delete(User user);
	
}
