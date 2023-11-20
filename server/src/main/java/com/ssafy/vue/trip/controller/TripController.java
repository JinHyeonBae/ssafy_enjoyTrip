package com.ssafy.vue.trip.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.trip.model.TripInfoDto;
import com.ssafy.vue.trip.model.TripScheduleDto;
import com.ssafy.vue.board.controller.BoardController;
import com.ssafy.vue.trip.model.TripDto;
import com.ssafy.vue.trip.model.TripFilterRequestDto;
import com.ssafy.vue.trip.model.service.TripService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tourlist")
@CrossOrigin("*")
@Api(tags = {"관광지 API"})
public class TripController {

	private static final Logger logger = LoggerFactory.getLogger(TripController.class);
	private TripService tripService;
	
	public TripController(TripService tripService) {
		this.tripService = tripService;
	}
	
	@ApiOperation(value = "모든 관광지 리스트", notes = "모든 관광지 리스트 불러오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "모든 관광지 리스트 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping("/")
	public ResponseEntity<?> getAllTourlist() throws Exception{
		try {
			List<TripInfoDto> tripList = tripService.getTripList();
			return ResponseEntity.ok().body(tripList);	
		} 
		catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@ApiOperation(value = "관광지 필터링 리스트", notes = "필터링한 관광지 리스트 불러오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "관광지 리스트 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping("/search") // title, guguncode
	public ResponseEntity<?> getTourlist(@RequestParam Map<String, String> queryParam) throws Exception{
		try {
			logger.debug("QUERY STRING : {} " + queryParam);
			TripFilterRequestDto filterDto = new TripFilterRequestDto();
			
			if(queryParam.get("sidoCode") != null)
				filterDto.setSidoCode(Integer.parseInt(queryParam.get("sidoCode")));
			
			if(queryParam.get("gugunCode") != null)
				filterDto.setGugunCode(Integer.parseInt(queryParam.get("gugunCode")));
			
			if(queryParam.get("contentTypeId") != null)
				filterDto.setContentTypeId(Integer.parseInt(queryParam.get("contentTypeId")));

			filterDto.setStart((Integer.parseInt(queryParam.get("start"))));
			filterDto.setListsize(Integer.parseInt(queryParam.get("listsize")));
			List<TripDto> tripList = tripService.getSpecificTripList(filterDto);
			return ResponseEntity.ok().body(tripList);
		} 
		catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@ApiOperation(value = "유저 관광지 저장", notes = "필터링한 관광지 리스트 불러오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "관광지 리스트 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@PostMapping("/store-schedule")
	// ContentType, 
	public ResponseEntity<?> storeSchedule(@RequestBody TripScheduleDto trips) throws Exception{
		try {
			logger.debug("StoreSchedule STRING : {} " + trips.getUser_id());
			
			//JSONObject jsonM = (JSONObject) trips.getContent();
			
			tripService.storeSchedule(trips);
			return ResponseEntity.status(201).body("정상 처리 되었습니다.");
		} 
		catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}
	
	
	
	

}
