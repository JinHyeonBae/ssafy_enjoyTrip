package com.ssafy.vue.comment.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ssafy.vue.comment.model.CommentDto;
import com.ssafy.vue.comment.model.ReqDelCommentDto;
import com.ssafy.vue.comment.model.ReqUpdateCommentDto;
import com.ssafy.vue.comment.model.ReqWriteCommentDto;
import com.ssafy.vue.comment.model.ResCommentListDto;
import com.ssafy.vue.comment.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	private SqlSession sqlSession;
	
	public CommentServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public ResCommentListDto getCommentList(int articleNo) throws Exception {
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		List<CommentDto> comments= commentMapper.getCommentList(articleNo);
		
		ResCommentListDto res = ResCommentListDto
								.builder()
								.status(HttpStatus.OK.value())
								.comment(comments)
								.totalCount(comments.size())
								.build();
		
		return res;
	}

	@Override
	public void writeComment(ReqWriteCommentDto comment) throws Exception {
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		
		commentMapper.writeComment(comment);
	}

	@Override
	public void modifyComment(ReqUpdateCommentDto comment) throws Exception {
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		
		commentMapper.modifyComment(comment);
	}

	@Override
	public void deleteComment(ReqDelCommentDto comment) throws Exception {
		
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		
		commentMapper.deleteComment(comment);
	}

}
