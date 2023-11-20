package com.ssafy.vue.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.trip.model.TripInfoDto;
import com.ssafy.vue.trip.model.TripScheduleDto;
import com.ssafy.vue.trip.model.TripDto;
import com.ssafy.vue.trip.model.TripFilterRequestDto;

@Mapper
public interface TripMapper {

	List<TripInfoDto> getTripList() throws SQLException;
	List<TripDto> getSpecificTripList(TripFilterRequestDto filterDto) throws SQLException;
	void storeSchedule(TripScheduleDto schedule) throws SQLException;
}
