package com.ssafy.vue.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.vue.trip.model.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ssafy.vue.trip.model.mapper.TripMapper;

@Service
public class TripServiceImpl implements TripService{

	//private static final Logger logger = LoggerFactory.getLogger(TripServiceImpl.class);
	
	private SqlSession sqlSession;
	
	public TripServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<TripInfoDto> getTripList() throws Exception {
		TripMapper tripMapper = sqlSession.getMapper(TripMapper.class);
		return tripMapper.getTripList();
	}

	@Override
	public List<TripDto> getSpecificTripList(TripFilterRequestDto filterDto) throws Exception {
		//logger.debug("VALE : {} " + filterDto);
		TripMapper tripMapper = sqlSession.getMapper(TripMapper.class);
		return tripMapper.getSpecificTripList(filterDto);
	}
	

	@Override
	public void storeSchedule(TripScheduleDto scheduleDto) throws Exception {
		TripMapper tripMapper = sqlSession.getMapper(TripMapper.class);
		tripMapper.storeSchedule(scheduleDto);
	}

	@Override
	public List<SidoDto>  getSidoCode() throws Exception {
		TripMapper tripMapper = sqlSession.getMapper(TripMapper.class);
		return tripMapper.getSidoCode();
	}




}
