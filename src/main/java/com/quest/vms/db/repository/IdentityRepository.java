package com.quest.vms.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quest.vms.db.entity.UserIdentity;

@Repository
public interface IdentityRepository extends JpaRepository<UserIdentity, Integer> {

	UserIdentity findByEmailIgnoreCase(String email);

}
