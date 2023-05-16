package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.CommentLikeDao;
import com.griter.model.dto.CommentLike;

@Service
public class CommentLikeServiceImpl implements CommentLikeService {
	
	@Autowired
	private CommentLikeDao commentLikeDao;
	
	@Override
	public List<CommentLike> selectAll() {
		return commentLikeDao.selectAll();
	}

	@Override
	public CommentLike selectByUser(int user_id) {
		return commentLikeDao.selectByUser(user_id);
	}

	@Override
	public CommentLike selectByPost(int post_id) {
		return commentLikeDao.selectByPost(post_id);
	}

	@Override
	public void create(CommentLike commentlike) {
		commentLikeDao.create(commentlike);
	}

	@Override
	public int delete(int comment_like_id) {
		return commentLikeDao.delete(comment_like_id);
	}

}
