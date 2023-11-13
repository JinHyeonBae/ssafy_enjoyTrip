package com.ssafy.vue.comment.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.board.model.BoardDto;
import com.ssafy.vue.board.model.BoardListDto;
import com.ssafy.vue.board.model.service.BoardService;
import com.ssafy.vue.comment.model.ReqDelCommentDto;
import com.ssafy.vue.comment.model.ReqUpdateCommentDto;
import com.ssafy.vue.comment.model.ReqWriteCommentDto;
import com.ssafy.vue.comment.model.ResBasicCommentDto;
import com.ssafy.vue.comment.model.ResCommentListDto;
import com.ssafy.vue.comment.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.fasterxml.jackson.databind.ObjectMapper;

//http://localhost/vue/swagger-ui.html
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/comment")
@Api("댓글 컨트롤러  API V1")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
//	private static final String SUCCESS = "success";
//	private static final String FAIL = "fail";
	
	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
//
//	@ApiOperation(value = "댓글작성", notes = "새로운 게시글 정보를 입력한다.")
//	@PostMapping
//	public ResponseEntity<?> writeArticle(
//			@RequestBody @ApiParam(value = "게시글 정보.", required = true) BoardDto boardDto) {
//		logger.info("writeArticle boardDto - {}", boardDto);
//		try {
//			boardService.writeArticle(boardDto);
////			return ResponseEntity.ok().build();
//			return new ResponseEntity<Void>(HttpStatus.CREATED);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}

	/*
	 * @ApiOperation(value = "댓글 목록", notes = "특정 게시글의 모든 댓글 정보를 반환한다.", response =
	 * List.class)
	 * 
	 * @ApiResponses({ @ApiResponse(code = 200, message =
	 * "회원목록 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
	 * 
	 * @ApiResponse(code = 500, message = "서버에러!!") })
	 * 
	 * @GetMapping("/{articleno}") public ResponseEntity<?> getCommentList(
	 * 
	 * @RequestParam @ApiParam(value = "게시글을 얻기위한 부가정보.", required =
	 * true) @RequestParam ) { logger.info("listArticle map - {}", map); try {
	 * BoardListDto boardListDto = boardService.listArticle(map); HttpHeaders header
	 * = new HttpHeaders(); header.setContentType(new MediaType("application",
	 * "json", Charset.forName("UTF-8"))); return
	 * ResponseEntity.ok().headers(header).body(boardListDto); } catch (Exception e)
	 * { return exceptionHandling(e); } }
	 */

	@ApiOperation(value = "특정 게시판 댓글 글보기", notes = "글번호에 해당하는 댓글의 정보를 반환한다.", response = ResCommentListDto.class)
	@GetMapping("/{articleNo}")
	public ResponseEntity<?> getCommentList(
			@PathVariable("articleNo") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleNo)
			throws Exception {
		try {
			return ResponseEntity.ok(commentService.getCommentList(articleNo));
		}
		catch(Exception e){
			logger.debug("getCommentList ERROR :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResBasicCommentDto(HttpStatus.BAD_REQUEST.value(), "댓글 불러오기 실패"));
		}
	}
	
	@ApiOperation(value = "댓글작성", notes = "새로운 댓글 정보를 입력한다.")
	@PostMapping
	public ResponseEntity<?> writeComment(
			@RequestBody @ApiParam(value = "댓글 정보.", required = true) ReqWriteCommentDto comment) {
		logger.info("writeComment WriteComment - {}", comment);
		try {
			commentService.writeComment(comment);
			return ResponseEntity.ok(new ResBasicCommentDto(HttpStatus.OK.value(), "댓글 생성 완료!"));
		} catch (Exception e) {
			logger.debug("writeComment ERROR :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResBasicCommentDto(HttpStatus.BAD_REQUEST.value(), "댓글 생성 실패"));
		}
	}
	
	
	@ApiOperation(value = "댓글 수정", notes = "댓글의 정보 수정", response = BoardDto.class)
	@PutMapping
	public ResponseEntity<?> modifyComment(@RequestBody ReqUpdateCommentDto comment)
			throws Exception {
		try {
			commentService.modifyComment(comment);
			return ResponseEntity.ok(new ResBasicCommentDto(HttpStatus.OK.value(), "댓글 수정 완료!"));
		} catch (Exception e) {
			logger.debug("modifyComment ERROR :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResBasicCommentDto(HttpStatus.BAD_REQUEST.value(), "댓글 수정 실패"));
		}
	}

	@ApiOperation(value = "댓글 글삭제", notes = "댓글 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<?> deleteComment(@RequestHeader(value="comment") String header) throws Exception {
		//logger.info("{}" + header);
		ObjectMapper objectMapper = new ObjectMapper();
		ReqDelCommentDto delDto = objectMapper.readValue(header, ReqDelCommentDto.class);

		System.out.println(delDto.getArticleNo());
		System.out.println(delDto.getCommentNo());
		System.out.println(delDto.getUserId());

		ReqDelCommentDto comment = new ReqDelCommentDto();
		comment.setArticleNo(delDto.getArticleNo());
		comment.setCommentNo(delDto.getCommentNo());
		comment.setUserId(delDto.getUserId());

		//logger.infon("TYPE : " + typeof(header))
		//ReqDelCommentDto comment = (ReqDelCommentDto) header.get("comment");
		//logger.info("deleteArticle - 호출---------------------- {}",comment);
		try {
			commentService.deleteComment(comment);
			return ResponseEntity.ok(new ResBasicCommentDto(HttpStatus.OK.value(), "댓글 삭제 완료!"));
		} catch (Exception e) {
			logger.debug("deleteComment ERROR :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResBasicCommentDto(HttpStatus.BAD_REQUEST.value(), "댓글 수정 실패"));
		}

	}
//
//	private ResponseEntity<String> exceptionHandling(Exception e) {
//		e.printStackTrace();
//		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}