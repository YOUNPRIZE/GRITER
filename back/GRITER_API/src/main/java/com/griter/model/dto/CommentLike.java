package com.griter.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentLikeDto : 댓글 좋아요 정보", description = "댓글 좋아요의 정보를 나타낸다.")
public class CommentLike {
	@ApiModelProperty(value = "댓글 좋아요 고유번호")
	private int comment_like_id;
	
	@ApiModelProperty(value = "사용자 ID")
	private int user_id;
	
	@ApiModelProperty(value = "댓글 ID")
	private int comment_id;
	
	public CommentLike() {}

	public CommentLike(int comment_like_id, int user_id, int comment_id) {
		super();
		this.comment_like_id = comment_like_id;
		this.user_id = user_id;
		this.comment_id = comment_id;
	}

	public int getComment_like_id() {
		return comment_like_id;
	}

	public void setComment_like_id(int comment_like_id) {
		this.comment_like_id = comment_like_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	@Override
	public String toString() {
		return "CommentLike [comment_like_id=" + comment_like_id + ", user_id=" + user_id + ", comment_id=" + comment_id
				+ "]";
	}
}
