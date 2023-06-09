package com.griter.model.dao;

import java.util.List;

import com.griter.model.dto.Follow;

public interface FollowDao {
	// create
	int createFollow(Follow follow);
	
	// user(내가 팔로우 하는 사람들 리스트 추출)
	List<Follow> selectByUserId(int user_id);
	
	List<Follow> selectByFollowingIdwithNickname(int user_id);

	// followed user(나를 팔로우 하는 사람들 리스트 추출)
	List<Follow> selectByFollowingId(int following_id);

	// 언팔
	int deleteFollow(Follow follow);
}
