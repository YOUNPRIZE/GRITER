package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.CommentLike;

public interface CommentLikeService {
	// 사용자로 불러오기
	List<CommentLike> selectByUser(int user_id);
	
	// 댓글별 불러오기
	List<CommentLike> selectByCommentId(int comment_id);
	
	// 좋아요 생성
	void create(CommentLike commentlike);
	
	// 좋아요 취소
	int delete(int comment_like_id);
}
