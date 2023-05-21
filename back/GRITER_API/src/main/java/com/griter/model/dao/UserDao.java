package com.griter.model.dao;

import java.util.List;

import com.griter.model.dto.User;

public interface UserDao {
	// 사용자 생성
	int create(User user);
	
	// 모든 사용자
	List<User> selectAll();
	
	// 아이디로 검색
	User selectByNickname(String nickname);
	
	// 사용자 수정
	int update(User user);
	
	// 사용자 삭제
	int delete(int user_id);
	
	// 비밀번호 반환
	String login(String nickname);
}
