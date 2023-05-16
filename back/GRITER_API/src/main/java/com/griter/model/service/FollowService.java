package com.griter.model.service;

import com.griter.model.dto.Follow;

public interface FollowService {
	// 모든 팔로우 정보 불러올 필요 X
	// 아 여기 좀 헷갈린다..

	// followed
	Follow selectByed(int user_id);

	// following
	Follow selectBying(int following_id);

}
