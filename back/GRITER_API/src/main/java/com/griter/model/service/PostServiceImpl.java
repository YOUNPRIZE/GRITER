package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.PostDao;
import com.griter.model.dto.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Override
	public int create(Post post) {
		return postDao.create(post);
	}

	@Override
	public List<Post> selectAll() {
		return postDao.selectAll();
	}

	@Override
	public List<Post> selectByPostId(int post_id) {
		return postDao.selectByPostId(post_id);
	}
	
	@Override
	public List<Post> selectCategory(String category) {
		return postDao.selectCategory(category);
	}

	@Override
	public List<Post> selectByUserId(int user_id) {
		return postDao.selectByUserId(user_id);
	}

	@Override
	public int update(Post post) {
		return postDao.update(post);
	}

	@Override
	public int delete(int post_id) {
		return postDao.delete(post_id);
	}

}
