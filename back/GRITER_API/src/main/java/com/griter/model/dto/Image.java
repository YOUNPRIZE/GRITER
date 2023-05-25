package com.griter.model.dto;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ImageDto : 이미지 경로 정보", description = "이미지 경로의 정보를 나타낸다.")
public class Image {
	@ApiModelProperty(value = "이미지 고유번호", example="0")
	private int image_id;
	
	@ApiModelProperty(value="사용자 ID", example="0")
	private int user_id;
	
	@ApiModelProperty(value = "이미지 데이터")
	private MultipartFile data;
	
	public Image() {}

	public Image(int image_id, int user_id, MultipartFile data) {
		super();
		this.image_id = image_id;
		this.user_id = user_id;
		this.data = data;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public MultipartFile getData() {
		return data;
	}

	public void setData(MultipartFile data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Image [image_id=" + image_id + ", user_id=" + user_id + ", data=" + data + "]";
	}

	
	
}
