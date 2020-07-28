package com.quest.vms.db.dao;

import com.quest.vms.dto.common.UserIdentityDTO;

public interface IdentityDAO {

	UserIdentityDTO saveUser(UserIdentityDTO dto);

}
