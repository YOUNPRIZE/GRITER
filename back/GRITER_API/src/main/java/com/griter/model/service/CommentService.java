package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Comment;

public interface CommentService {
	// 모든 댓글 불러오기
	List<Comment> selectAll();

	// 게시글별 댓글 불러오기
	List<Comment> selectByPost(int post_id);

	// 사용자별 댓글 불러오기
	List<Comment> selectByUser(int user_id);

	// 대댓글 불러오기
	List<Comment> selectByComment(int parent_id);

	// 댓글 생성
	void create(Comment comment);

	// 댓글 수정
	int update(Comment comment);

	// 댓글 삭제
	int delete(int comment_id);
}
