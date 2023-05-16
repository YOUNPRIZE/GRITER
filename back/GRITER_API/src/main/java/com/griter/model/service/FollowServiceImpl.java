package com.griter.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.FollowDao;
import com.griter.model.dto.Follow;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowDao followDao;
	
	@Override
	public Follow selectByed(int user_id) {
		return followDao.selectByed(user_id);
	}

	@Override
	public Follow selectBying(int following_id) {
		return followDao.selectBying(following_id);
	}

}
