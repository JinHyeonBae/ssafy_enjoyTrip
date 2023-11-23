package com.ssafy.vue.trip.model.service;

import java.util.List;

import com.ssafy.vue.trip.model.*;

public interface TripService {
	
	List<TripInfoDto> getTripList() throws Exception;
	List<TripDto> getSpecificTripList(TripFilterRequestDto filterDto) throws Exception;
	void storeSchedule(TripScheduleDto scheduleDto) throws Exception;

	List<SidoDto> getSidoCode() throws Exception;
	List<TripScheduleDto> getUserSchedule(String userId) throws Exception;
	void deleteUserSchedule(TripDeleteDto deleteDto) throws Exception;

	
}
