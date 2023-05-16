package com.griter.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentDto : 댓글 정보", description = "댓글의 정보를 나타낸다.")
public class Comment {
	@ApiModelProperty(value = "댓글 고유번호")
	private int comment_id;
	
	@ApiModelProperty(value = "내용")
	private String content;
	
	@ApiModelProperty(value = "상위 댓글번호")
	private int parent_id;
	
	@ApiModelProperty(value = "댓글 작성자")
	private int user_id;
	
	@ApiModelProperty(value = "게시글 번호")
	private int post_id;
	
	@ApiModelProperty(value = "생성일")
	private String generated_date;
	
	@ApiModelProperty(value = "수정일")
	private String modified_date;
	
	public Comment() {}

	public Comment(int comment_id, String content, int parent_id, int user_id, int post_id, String generated_date,
			String modified_date) {
		super();
		this.comment_id = comment_id;
		this.content = content;
		this.parent_id = parent_id;
		this.user_id = user_id;
		this.post_id = post_id;
		this.generated_date = generated_date;
		this.modified_date = modified_date;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
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

	public String getGenerated_date() {
		return generated_date;
	}

	public void setGenerated_date(String generated_date) {
		this.generated_date = generated_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", content=" + content + ", parent_id=" + parent_id + ", user_id="
				+ user_id + ", post_id=" + post_id + ", generated_date=" + generated_date + ", modified_date="
				+ modified_date + "]";
	}
}
