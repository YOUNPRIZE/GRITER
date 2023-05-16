package com.griter.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FollowDto : 팔로우 정보", description = "팔로우 정보를 나타낸다.")
public class Follow {
	@ApiModelProperty(value = "팔로우 고유번호")
	private int follow_id;
	
	@ApiModelProperty(value = "followed")
	private int user_id;
	
	@ApiModelProperty(value = "following")
	private int following_id;
	
	public Follow() {}

	public Follow(int follow_id, int user_id, int following_id) {
		super();
		this.follow_id = follow_id;
		this.user_id = user_id;
		this.following_id = following_id;
	}

	public int getFollow_id() {
		return follow_id;
	}

	public void setFollow_id(int follow_id) {
		this.follow_id = follow_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFollowing_id() {
		return following_id;
	}

	public void setFollowing_id(int following_id) {
		this.following_id = following_id;
	}

	@Override
	public String toString() {
		return "Follow [follow_id=" + follow_id + ", user_id=" + user_id + ", following_id=" + following_id + "]";
	}
}
