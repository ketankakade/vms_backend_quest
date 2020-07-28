package com.quest.vms.dto.common;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)

public class UserDto {

	@JsonIgnore
	private long id;

	private String firstName;
	private String lastName;
	private String email;
	private long contactNo;
	private String idProof;
	private String placeOfVisit;
	private String reasonForVisit;
	private String visitorType;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime lastUpdate;
	private List<ContactPersonDto> contactPerson;
	private List<TimeSlotDto> timeSlot;
	private List<DeviceDto> device;

}
