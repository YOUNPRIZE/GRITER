package com.griter.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ImageDto : 이미지 경로 정보", description = "이미지 경로의 정보를 나타낸다.")
public class Image {
	@ApiModelProperty(value = "이미지 고유번호", example="0")
	private int image_id;
	
	@ApiModelProperty(value = "이미지 경로")
	private String img_path;
	
	@ApiModelProperty(value = "게시글 ID", example="0")
	private int post_id;
	
	public Image() {}

	public Image(int image_id, String img_path, int post_id) {
		super();
		this.image_id = image_id;
		this.img_path = img_path;
		this.post_id = post_id;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	@Override
	public String toString() {
		return "Image [image_id=" + image_id + ", img_path=" + img_path + ", post_id=" + post_id + "]";
	}
}
