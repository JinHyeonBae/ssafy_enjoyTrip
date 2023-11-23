package com.ssafy.vue.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.ssafy.vue.board.model.BoardDto;
import com.ssafy.vue.board.model.BoardListDto;
import com.ssafy.vue.board.model.FileInfoDto;
import com.ssafy.vue.board.model.LatestBoardDto;
import com.ssafy.vue.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//http://localhost/vue/swagger-ui.html
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러  API V1")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

//	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다.")
//	@PostMapping
//	public ResponseEntity<?> writeArticle(
//			@RequestBody @ApiParam(value = "게시글 정보.", required = true) BoardDto boardDto) {
//		logger.debug("writeArticle boardDto - {}", boardDto);
//		try {
//			boardService.writeArticle(boardDto);
////			return ResponseEntity.ok().build();
//			return new ResponseEntity<Void>(HttpStatus.CREATED);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
//	
	@Value("${file.path}")
	private String saveRootPath;
	
	private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
	
	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다.")
	@PostMapping
	public ResponseEntity<?> writeArticleFile(
			@RequestPart(value = "upfile", required=false) MultipartFile[] multiFiles,
			@RequestPart(value = "article", required=false) BoardDto boardDto){
		logger.debug("writeArticle article - {}", boardDto);
		if(multiFiles != null) {
			logger.debug("writeArticle file - {}", multiFiles[0]);
			String currentPath = new File("").getAbsolutePath();
			currentPath = currentPath.replaceAll("\\\\","/");
			logger.debug("currentPath - {}", currentPath+"/"+saveRootPath);
			
			FileInfoDto fileInfoDto;
			String  uuId, saveFolder,originalFile,saveFile;
			List<FileInfoDto> fileInfos = new ArrayList<>();
	        for (int i = 0; i < multiFiles.length; i++) {
	            if (!multiFiles[i].isEmpty()) {
	                logger.debug("saveRootPath :: {}", saveRootPath);
	                logger.debug("file.getOriginalFilename() :: {}", multiFiles[i].getOriginalFilename());
	                logger.debug("file size :: {}", multiFiles[i].getSize());
	                
	                uuId = UUID.randomUUID().toString();
	                //window
//	                saveFolder = currentPath+"/"+saveRootPath;
	                //mac
	                saveFolder = saveRootPath;
	                originalFile = multiFiles[i].getOriginalFilename();
	                saveFile = getToDate() + "_" + uuId+ originalFile.substring(originalFile.lastIndexOf("."));
	                fileInfoDto = new FileInfoDto(saveFolder,originalFile,saveFile);
	                
	             // 파일에 저장하기
	                logger.debug("dest :: {}", saveFolder + saveFile);
	                File dest = new File(saveFolder + saveFile);
	                try {
	                	//파일 저장.
						multiFiles[i].transferTo(dest);
						
						//fileInfos에 담기.
		                fileInfos.add(fileInfoDto);
		                logger.debug("fileInfoDto :: {}", fileInfoDto);
					} catch (IOException e) {
						System.out.println(e);
					}
	            }
	        }
	      //boardDto에 담기.
	        boardDto.setFileInfos(fileInfos);
		}
		try {
			boardService.writeArticle(boardDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	@GetMapping("/display/{file}")
    public ResponseEntity<Object> download( @PathVariable("file") String file) {
        logger.debug("download file info  file : {}",  file);
        String fileP = saveRootPath + File.separator + file;

        try {
            Path filePath = Paths.get(fileP);
            Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(URLEncoder.encode(file, "UTF-8").replaceAll("\\+", "%20")).build());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
        }
    }
	

	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!")})
	@GetMapping
	public ResponseEntity<?> listArticle(
			@RequestParam @ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) Map<String, String> map) {
		logger.info("listArticle map - {}", map);
		try {
			BoardListDto boardListDto = boardService.listArticle(map);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(boardListDto);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	@ApiOperation(value = "최신 게시판 글목록", notes = "최신 게시글의 정보를 반환한다.", response = List.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!")})
	@GetMapping("/latest")
	public ResponseEntity<?> latestListArticle() {
		logger.info("latestListArticle");
		try {
			List<LatestBoardDto> latestArticles = boardService.latestListArticle();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(latestArticles);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{articleno}")
	public ResponseEntity<BoardDto> getArticle(
			@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno)
			throws Exception {
		logger.info("getArticle - 호출 : " + articleno);
		boardService.updateHit(articleno);
		return new ResponseEntity<BoardDto>(boardService.getArticle(articleno), HttpStatus.OK);
	}

	@ApiOperation(value = "수정 할 글 얻기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/modify/{articleno}")
	public ResponseEntity<BoardDto> getModifyArticle(
			@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno)
			throws Exception {
		logger.info("getModifyArticle - 호출 : " + articleno);
		return new ResponseEntity<BoardDto>(boardService.getArticle(articleno), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글수정", notes = "수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyArticle(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) BoardDto boardDto) throws Exception {
		logger.info("modifyArticle - 호출 {}", boardDto);
		boardService.modifyArticle(boardDto);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{articleno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleno") @ApiParam(value = "살제할 글의 글번호.", required = true) int articleno) throws Exception {
		logger.info("deleteArticle - 호출");
		boardService.deleteArticle(articleno,saveRootPath);
		return ResponseEntity.ok().build();

	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}