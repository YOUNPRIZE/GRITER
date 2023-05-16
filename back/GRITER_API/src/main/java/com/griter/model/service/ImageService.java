package com.griter.model.service;

import com.griter.model.dto.Image;

public interface ImageService {
	// 게시물 별 이미지
	Image selectByPost(int post_id);

	// 이미지 등록
	void create(Image img);

	// 이미지 삭제
	int delete(int image_id);
}
