package com.ssafy.vue.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.member.model.MemberDto;
import com.ssafy.vue.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return memberMapper.login(memberDto);
	}
	
	@Override
	public void join(MemberDto memberDto) throws Exception {
		memberMapper.join(memberDto);
	}
	
	@Override
	public MemberDto userInfo(String userId) throws Exception {
		return memberMapper.userInfo(userId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int checkId(String userId) throws Exception{
		MemberDto memberDto = memberMapper.userInfo(userId);
		if(memberDto == null) return 0; //해당 아이디로 한번도 가입한 이력이 없거나 탈퇴한 이력이 있는 경우
		return 1;
	}
	
	

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return memberMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);
	}

	@Override
	public void update(MemberDto memberDto) throws Exception {
		memberMapper.update(memberDto);
	}

	@Override
	public void delete(String userId) throws Exception {
		memberMapper.delete(userId);
		
	}

}
