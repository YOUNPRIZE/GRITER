package com.griter.model.dao;

import java.util.List;

import com.griter.model.dto.PostLike;

public interface PostLikeDao {
	// 좋아요 생성
	int create(PostLike postlike);
	
	// 사용자로 불러오기
	List<PostLike> selectByUser(int user_id);
	
	// 게시물별 불러오기
	List<PostLike> selectByPost(int post_id);
	
	// 좋아요 취소
	int delete(int post_id, int user_id);
}
