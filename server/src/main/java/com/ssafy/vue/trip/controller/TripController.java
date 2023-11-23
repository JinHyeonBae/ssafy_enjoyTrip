package com.ssafy.vue.trip.controller;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.vue.comment.model.ReqDelCommentDto;
import com.ssafy.vue.trip.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.vue.board.controller.BoardController;
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
			System.out.println("Q : " + queryParam.get("sidoCode").isEmpty());

			if(!queryParam.get("sidoCode").equals("0") && queryParam.get("sidoCode") != null && !queryParam.get("sidoCode").isEmpty())
				filterDto.setSidoCode(Integer.parseInt(queryParam.get("sidoCode")));

			System.out.println("Q : " + queryParam.get("gugunCode").isEmpty());
			if(queryParam.get("gugunCode") != null && !queryParam.get("gugunCode").isEmpty())
				filterDto.setGugunCode(Integer.parseInt(queryParam.get("gugunCode")));

			System.out.println("Q : " + queryParam.get("contentTypeId").isEmpty());
			if(queryParam.get("contentTypeId") != null && !queryParam.get("contentTypeId").isEmpty())
				filterDto.setContentTypeId(Integer.parseInt(queryParam.get("contentTypeId")));

			if(queryParam.get("title") != null && !queryParam.get("title").isEmpty())
				filterDto.setTitle(queryParam.get("title"));

			filterDto.setStart((Integer.parseInt(queryParam.get("start"))));
			filterDto.setListsize(Integer.parseInt(queryParam.get("listsize")));

			System.out.println("DATA : " + filterDto.toString());
			List<TripDto> tripList = tripService.getSpecificTripList(filterDto);
			System.out.println("TRIPLIST LENGTH : " + tripList.size());
			return ResponseEntity.ok().body(tripList);
		} 
		catch (Exception e) {
			System.out.println("ERROR CAUSE");
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause());

			return ResponseEntity.status(404).body(e.getCause() + " : \n" + e.getMessage());
		}
	}

	@ApiOperation(value = "유저가 선택한 관광지 저장", notes = "필터링한 관광지 리스트 불러오기")
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
			System.out.println("storeSchedule");
			System.out.println("ERROR CAUSE");
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause());
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}


	@ApiOperation(value = "시도 코드 출력 저장", notes = "시도 리스트 불러오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "관광지 리스트 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping("/sido")
	// ContentType,
	public ResponseEntity<?> getSidoCode() throws Exception{
		try {
			List<SidoDto> sido = tripService.getSidoCode();
			return ResponseEntity.status(200).body(sido);
		}
		catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}


	@ApiOperation(value = "검색 기능", notes = "필터링한 관광지 리스트 불러오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "관광지 리스트 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping("/search-content")
	// ContentType,
	public ResponseEntity<?> searchByContent() throws Exception{
		try {
			List<SidoDto> sido = tripService.getSidoCode();
			return ResponseEntity.status(200).body(sido);
		}
		catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@ApiOperation(value = "검색 기능", notes = "필터링한 관광지 리스트 불러오기")
	@ApiResponses({ @ApiResponse(code = 200, message = "관광지 리스트 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping("/get-schedule")
	// ContentType,
	public ResponseEntity<?> getUserSchedule(@RequestHeader String userId) throws Exception{
		try {
			List<TripScheduleDto> schedules = tripService.getUserSchedule(userId);
			return ResponseEntity.status(200).body(schedules);
		}
		catch (Exception e) {
			System.out.println("GET SCHEUDLE");
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause());

			return ResponseEntity.status(400).body(e.getMessage());
		}
	}


	@ApiOperation(value = "여행 계획 삭제 기능", notes = "삭제")
	@ApiResponses({ @ApiResponse(code = 200, message = "삭제 완료"), @ApiResponse(code = 404, message = "페이지없어!!"),			@ApiResponse(code = 500, message = "서버에러!!") })
	@DeleteMapping("")
	// ContentType,
	public ResponseEntity<?> deleteUserSchedule(@RequestHeader(value="param") String headers) throws Exception{
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			TripDeleteDto delDto = objectMapper.readValue(headers, TripDeleteDto.class);

			System.out.println(delDto.getUserId());
			System.out.println(delDto.getScheduleId());
//
//			TripDeleteDto deleteDto = new TripDeleteDto();
//			deleteDto.setUserId(headers.get("userId"));
//
//			deleteDto.setScheduleId(delDto.getScheduleId());

			tripService.deleteUserSchedule(delDto);
			return ResponseEntity.status(200).body("삭제가 완료되었습니다.");
		}
		catch (Exception e) {
			System.out.println("GET SCHEUDLE");
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause());

			return ResponseEntity.status(400).body(e.getMessage());
		}
	}






}
