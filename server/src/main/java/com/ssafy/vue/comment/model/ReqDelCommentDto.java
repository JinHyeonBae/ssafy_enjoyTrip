package com.ssafy.vue.comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

///*@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor*/
@Data
public class ReqDelCommentDto {
	
	Integer articleNo;
	Integer commentNo;
	String userId;	
}
