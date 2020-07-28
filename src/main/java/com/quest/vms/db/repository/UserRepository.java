package com.quest.vms.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quest.vms.db.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public User findById(long id);
}
