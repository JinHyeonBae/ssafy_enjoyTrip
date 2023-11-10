package com.ssafy.vue.comment.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResCommentListDto {

	Integer status;
	List<CommentDto> comment;
	Integer totalCount;
	
}

