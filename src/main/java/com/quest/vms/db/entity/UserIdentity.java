package com.quest.vms.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(
	    name = "user_identity",
	    indexes = {@Index(name = "email_index", columnList = "email", unique = true)})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIdentity {

	 private static final String COLUMN_USER_PK = "user_id";

	  private static final String FIRST_NAME = "first_name";

	  private static final String LAST_NAME = "last_name";

	  private static final String EMAIL = "email";

	  private static final String MOBILE_NUMBER = "mobile_number";
	  
	  private static final String LAST_SIGN_TS = "lastSignIn";
	  
	  private static final String SALTED_HASH = "salted_hash";

	  private static final String NONCE = "nonce";

	  @Id
	  @Column(name = COLUMN_USER_PK)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer userId;

	  @Column(name = FIRST_NAME, columnDefinition = "text", nullable = false)
	  private String firstName;

	  @Column(name = LAST_NAME, columnDefinition = "text", nullable = false)
	  private String lastName;

	  @Column(name = EMAIL, columnDefinition = "text", nullable = false, unique = true)
	  private String email;

	  @Column(name = MOBILE_NUMBER, length = 15, nullable = false)
	  private String mobileNumber;
	  
	  @Column(name = LAST_SIGN_TS)
	  private Timestamp lastSignIn;
	  
	  @Column(name = SALTED_HASH, columnDefinition = "text", nullable = false)
	  private String saltedHash;

	  @Column(name = NONCE, nullable = false)
	  private String nonce;

}
