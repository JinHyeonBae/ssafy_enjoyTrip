package com.ssafy.vue.comment.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.board.model.BoardDto;
import com.ssafy.vue.board.model.FileInfoDto;
import com.ssafy.vue.comment.model.CommentDto;
import com.ssafy.vue.comment.model.ReqDelCommentDto;
import com.ssafy.vue.comment.model.ReqUpdateCommentDto;
import com.ssafy.vue.comment.model.ReqWriteCommentDto;
import com.ssafy.vue.comment.model.ResCommentListDto;

@Mapper
public interface CommentMapper {

	List<CommentDto> getCommentList(int articleNo) throws SQLException;
	
	void writeComment(ReqWriteCommentDto comment) throws SQLException;
	
	void modifyComment(ReqUpdateCommentDto comment) throws SQLException;
	
	void deleteComment(ReqDelCommentDto comment) throws SQLException;
	
//	void registerFile(BoardDto boardDto) throws Exception;
//
//	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
//
//	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
//
//	BoardDto getArticle(int articleNo) throws SQLException;
//
//	void updateHit(int articleNo) throws SQLException;
//
//	void modifyArticle(BoardDto boardDto) throws SQLException;
//
//	void deleteFile(int articleNo) throws Exception;
//
//	void deleteArticle(int articleNo) throws SQLException;
//
//	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;
	
}
