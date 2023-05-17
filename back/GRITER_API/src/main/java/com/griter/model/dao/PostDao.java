package com.griter.model.dao;

import java.util.List;

import com.griter.model.dto.Post;

public interface PostDao {
	// 게시글 등록
	void create(Post post);
	
	// 모든 게시글
	List<Post> selectAll();
	
	// 카테고리별 게시글
	List<Post> selectCategory(String category);
	
	// user가 쓴 모든 글
	List<Post> selectByUserId(int user_id);
	
	// 게시글 수정
	int update(Post post);
	
	// 게시글 삭제
	int delete(int post_id);
}