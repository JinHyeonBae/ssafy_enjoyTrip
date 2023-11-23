package com.ssafy.vue.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.vue.trip.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TripMapper {

	List<TripInfoDto> getTripList() throws SQLException;
	List<TripDto> getSpecificTripList(TripFilterRequestDto filterDto) throws SQLException;
	void storeSchedule(TripScheduleDto schedule) throws SQLException;
	List<SidoDto> getSidoCode() throws SQLException;

	List<TripScheduleDto> getUserSchedule(String userId) throws SQLException;
}
