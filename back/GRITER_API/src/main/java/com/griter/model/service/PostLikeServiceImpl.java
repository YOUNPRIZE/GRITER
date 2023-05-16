package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.PostLikeDao;
import com.griter.model.dto.PostLike;

@Service
public class PostLikeServiceImpl implements PostLikeService {

	@Autowired
	private PostLikeDao postLikeDao;

	@Override
	public void create(PostLike postlike) {
		postLikeDao.create(postlike);
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
	public int delete(int post_like_id) {
		return postLikeDao.delete(post_like_id);
	}
	

}
