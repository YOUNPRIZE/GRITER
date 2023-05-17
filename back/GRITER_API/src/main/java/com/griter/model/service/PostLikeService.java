package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.PostLike;

public interface PostLikeService {
	// 좋아요 생성
	void create(PostLike postlike);
	
	// 사용자로 불러오기
	List<PostLike> selectByUser(int user_id);
	
	// 게시물별 불러오기
	List<PostLike> selectByPost(int post_id);
	
	// 좋아요 취소
	int delete(PostLike postLike);
}
