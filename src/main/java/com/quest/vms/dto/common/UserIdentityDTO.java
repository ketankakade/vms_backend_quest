package com.quest.vms.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserIdentityDTO {
	
	 private String userId;

	  private String firstName;

	  private String lastName;

	  private String email;

	  private String mobileNumber;

	  private String consumerNumber;

	  private String saltedHash;

	  private String nonce;

}
