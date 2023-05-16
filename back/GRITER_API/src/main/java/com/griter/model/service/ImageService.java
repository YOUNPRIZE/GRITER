package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Image;

public interface ImageService {
	// 이미지 등록
	void create(Image img);
	
	// 게시물 별 이미지
	List<Image> selectByPost(int post_id);
	
	// 이미지 삭제
	int delete(int image_id);
}
