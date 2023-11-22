package com.ssafy.vue.member.model.service;

import java.sql.SQLException;

import com.ssafy.vue.member.model.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto memberDto) throws Exception;
	MemberDto userInfo(String userId) throws Exception;
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	void deleRefreshToken(String userId) throws Exception;
	void join(MemberDto memberDto) throws Exception;
	int checkId(String userId) throws Exception;
	void update(MemberDto memberDto) throws Exception;
	void delete(String userId) throws Exception;
}
