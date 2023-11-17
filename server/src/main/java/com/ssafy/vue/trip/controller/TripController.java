package com.ssafy.vue.trip.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.trip.model.TripInfoDto;
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
@Api(tags = {"관광지 API V1"})
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
	
	@PutMapping("/")
	public ResponseEntity<?> r() throws Exception{
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
	// ContentType, 
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
	

}
