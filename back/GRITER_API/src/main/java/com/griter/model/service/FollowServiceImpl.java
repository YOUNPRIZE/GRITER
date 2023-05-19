package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.FollowDao;
import com.griter.model.dto.Follow;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowDao followDao;

	@Override
	public int createFollow(Follow follow) {
		return followDao.createFollow(follow);
	}

	@Override
	public List<Follow> selectByUserId(int user_id) {
		return followDao.selectByUserId(user_id);
	}

	@Override
	public List<Follow> selectByFollowedId(int followed_id) {
		return followDao.selectByFollowedId(followed_id);
	}

	@Override
	public int deleteFollow(Follow follow) {
		return followDao.deleteFollow(follow);
	}

}
