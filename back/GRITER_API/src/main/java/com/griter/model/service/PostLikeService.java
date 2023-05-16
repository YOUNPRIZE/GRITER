package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.PostLike;

public interface PostLikeService {
	// 모든 게시물 좋아요 불러오기 (필요한가??)
	List<PostLike> selectAll();

	// 사용자로 불러오기
	PostLike selectByUser(int user_id);

	// 게시물별 불러오기
	PostLike selectByPost(int post_id);

	// 좋아요 생성
	void create(PostLike postlike);

	// 좋아요 취소
	int delete(int post_like_id);
}
