package com.ssafy.vue.trip.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripFilterRequestDto{
	private Integer sidoCode;
	private Integer gugunCode;
	private Integer contentTypeId;
	private Integer start;
	private Integer listsize;
	
	@Override
	public String toString() {
		return "TripFilterRequestDto [sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", contentTypeId="
				+ contentTypeId + ", start=" + start + ", listsize=" + listsize + "]";
	}
	
	
	
	
}
