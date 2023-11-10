package com.ssafy.vue.comment.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.vue.comment.model.CommentDto;
import com.ssafy.vue.comment.model.ReqDelCommentDto;
import com.ssafy.vue.comment.model.ReqUpdateCommentDto;
import com.ssafy.vue.comment.model.ReqWriteCommentDto;
import com.ssafy.vue.comment.model.ResCommentListDto;

public interface CommentService {

	ResCommentListDto getCommentList(int articleNo) throws Exception;
	
	void writeComment(ReqWriteCommentDto comment) throws Exception;
	
	void modifyComment(ReqUpdateCommentDto comment) throws Exception;
	
	void deleteComment(ReqDelCommentDto comment) throws Exception;
	
}
