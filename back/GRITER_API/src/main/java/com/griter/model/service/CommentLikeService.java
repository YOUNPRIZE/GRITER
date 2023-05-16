package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.CommentLike;

public interface CommentLikeService {
	// 모든 댓글 좋아요 불러오기 (필요한가??)
	List<CommentLike> selectAll();

	// 사용자로 불러오기
	CommentLike selectByUser(int user_id);

	// 댓글별 불러오기
	CommentLike selectByPost(int post_id);

	// 좋아요 생성
	void create(CommentLike commentlike);

	// 좋아요 취소
	int delete(int comment_like_id);
}
