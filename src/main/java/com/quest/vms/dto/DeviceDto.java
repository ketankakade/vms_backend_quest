package com.quest.vms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class DeviceDto {
	
	@JsonIgnore
	private long id;	
	private long deviceSN;
	private String deviceType;
	private String deviceMake;
}
