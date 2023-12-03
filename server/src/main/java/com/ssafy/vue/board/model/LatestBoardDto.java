package com.ssafy.vue.board.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardDto : 게시글정보", description = "게시글의 상세 정보를 나타낸다.")
public class LatestBoardDto {

	@ApiModelProperty(value = "글번호")
	private int articleNo;
	@ApiModelProperty(value = "글제목")
	private String subject;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "업로드 파일정보")
	private String saveFile;
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSaveFile() {
		return saveFile;
	}
	public void setSaveFile(String save_file) {
		this.saveFile = save_file;
	}
	@Override
	public String toString() {
		return "LatestBoardDto [articleNo=" + articleNo + ", subject=" + subject + ", content=" + content
				+ ", saveFile=" + saveFile + "]";
	}

	
}
