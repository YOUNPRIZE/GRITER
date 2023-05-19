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
	public int create(CommentLike commentlike) {
		return commentLikeDao.create(commentlike);
	}
	
	@Override
	public List<CommentLike> selectByUser(int user_id) {
		return commentLikeDao.selectByUser(user_id);
	}

	@Override
	public List<CommentLike> selectByCommentId(int comment_id) {
		return commentLikeDao.selectByCommentId(comment_id);
	}

	@Override
	public int delete(int comment_like_id) {
		return commentLikeDao.delete(comment_like_id);
	}
	

}
