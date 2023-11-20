package com.ssafy.vue.trip.model.service;

import java.util.List;

import com.ssafy.vue.trip.model.TripInfoDto;
import com.ssafy.vue.trip.model.TripScheduleDto;
import com.ssafy.vue.trip.model.TripDto;
import com.ssafy.vue.trip.model.TripFilterRequestDto;

public interface TripService {
	
	List<TripInfoDto> getTripList() throws Exception;
	List<TripDto> getSpecificTripList(TripFilterRequestDto filterDto) throws Exception;
	public void storeSchedule(TripScheduleDto scheduleDto) throws Exception;
	
}
