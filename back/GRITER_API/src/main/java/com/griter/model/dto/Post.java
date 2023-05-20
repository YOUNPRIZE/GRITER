package com.griter.model.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PostDto : 게시글 정보", description = "게시글의 정보를 나타낸다.")
public class Post {
	@ApiModelProperty(value = "게시글 고유번호")
	private int post_id;
	
	@ApiModelProperty(value = "게시자 아이디")
	private int user_id;
	
	@ApiModelProperty(value = "제목")
	private String title;
	
	@ApiModelProperty(value = "내용")
	private String content;
	
	@ApiModelProperty(value = "생성일")
	private Date generated_date;
	
	@ApiModelProperty(value = "수정일")
	private Date modified_date;
	
	@ApiModelProperty(value = "조회수")
	private int view_cnt;
	
	@ApiModelProperty(value = "좋아요수")
	private int like_cnt;
	
	@ApiModelProperty(value = "분류")
	private String category;
	
	public Post() {}

	public Post(int post_id, int user_id, String title, String content, Date generated_date, Date modified_date,
			int view_cnt, int like_cnt, String category) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.generated_date = generated_date;
		this.modified_date = modified_date;
		this.view_cnt = view_cnt;
		this.like_cnt = like_cnt;
		this.category = category;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getGenerated_date() {
		return generated_date;
	}

	public void setGenerated_date(Date generated_date) {
		this.generated_date = generated_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", user_id=" + user_id + ", title=" + title + ", content=" + content
				+ ", generated_date=" + generated_date + ", modified_date=" + modified_date + ", view_cnt=" + view_cnt
				+ ", like_cnt=" + like_cnt + ", category=" + category + "]";
	}
}
