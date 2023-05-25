package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.griter.model.dao.PostLikeDao;
import com.griter.model.dto.PostLike;

@Service
public class PostLikeServiceImpl implements PostLikeService {

	@Autowired
	private PostLikeDao postLikeDao;

	@Override
	@Transactional
	public int create(PostLike postlike) {
		return postLikeDao.create(postlike);
	}

	@Override
	public List<PostLike> selectByUser(int user_id) {
		return postLikeDao.selectByUser(user_id);
	}

	@Override
	public List<PostLike> selectByPost(int post_id) {
		return postLikeDao.selectByPost(post_id);
	}

	@Override
	public int delete(int post_id, int user_id) {
		return postLikeDao.delete(post_id, user_id);
	}
	

}
