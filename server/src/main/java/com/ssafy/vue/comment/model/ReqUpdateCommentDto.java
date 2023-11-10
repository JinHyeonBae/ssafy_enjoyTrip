package com.ssafy.vue.comment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqUpdateCommentDto {

	Integer articleNo;
	Integer commentNo;
	String content;
	String userId;	
}
