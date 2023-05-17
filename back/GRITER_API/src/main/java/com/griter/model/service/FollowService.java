package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Follow;

public interface FollowService {
	// create
	void createFollow(Follow follow);
	
	// user(내가 팔로우 하는 사람들 리스트 추출)
	List<Follow> selectByUserId(int user_id);

	// followed user(나를 팔로우 하는 사람들 리스트 추출)
	List<Follow> selectByFollowedId(int followed_id);

	// 언팔
	int deleteFollow(Follow follow);
}