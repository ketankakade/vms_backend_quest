package com.quest.vms.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;

	@NotNull
	private String firstName;
	
	private String lastName;
	
	@NotNull
	@Column(unique = true)
	@Email
	private String email;
	
	@NotNull
	//@Size(max=10,min=10)
	private long contactNo;

	@NotNull
	private String idProof;

	@NotNull
	private String placeOfVisit;
	
	@NotNull
	private String reasonForVisit;

	@NotNull
	private String visitorType;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdate;
	
	//image

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="userId",referencedColumnName="id")
 	private List<ContactPerson> contactPerson;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userId",referencedColumnName="id")
 	private List<Device> device;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userId",referencedColumnName="id")
 	private List<TimeSlot> timeSlot;
}
