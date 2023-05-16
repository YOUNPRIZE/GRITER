package com.griter.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PostLikeDto : 게시글 좋아요 정보", description = "게시글 좋아요 정보를 나타낸다.")
public class PostLike {
	@ApiModelProperty(value = "게시글 좋아요 고유번호")
	private int post_like_id;
	
	@ApiModelProperty(value = "사용자 ID")
	private int user_id;
	
	@ApiModelProperty(value = "게시글 ID")
	private int post_id;
	
	public PostLike() {}

	public PostLike(int post_like_id, int user_id, int post_id) {
		super();
		this.post_like_id = post_like_id;
		this.user_id = user_id;
		this.post_id = post_id;
	}

	public int getPost_like_id() {
		return post_like_id;
	}

	public void setPost_like_id(int post_like_id) {
		this.post_like_id = post_like_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	@Override
	public String toString() {
		return "PostLike [post_like_id=" + post_like_id + ", user_id=" + user_id + ", post_id=" + post_id + "]";
	}
}
