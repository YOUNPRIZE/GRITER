package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.User;

public interface UserService {
	// 사용자 생성
	void create(User user);
	
	// 모든 사용자
	List<User> selectAll();
	
	// 아이디로 검색
	User selectById(String nickname);
	
	// 사용자 수정
	int update(User user);
	
	// 사용자 삭제
	int delete(int user_id);
}