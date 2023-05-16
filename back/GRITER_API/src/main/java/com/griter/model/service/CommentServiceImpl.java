package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.CommentDao;
import com.griter.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> selectAll() {
		return commentDao.selectAll();
	}

	@Override
	public List<Comment> selectByPost(int post_id) {
		return commentDao.selectByPost(post_id);
	}

	@Override
	public List<Comment> selectByUser(int user_id) {
		return commentDao.selectByUser(user_id);
	}

	@Override
	public List<Comment> selectByComment(int parent_id) {
		return commentDao.selectByComment(parent_id);
	}

	@Override
	public void create(Comment comment) {
		commentDao.create(comment);
	}

	@Override
	public int update(Comment comment) {
		return commentDao.update(comment);
	}

	@Override
	public int delete(int comment_id) {
		return commentDao.delete(comment_id);
	}

}
