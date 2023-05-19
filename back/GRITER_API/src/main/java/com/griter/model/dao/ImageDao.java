package com.griter.model.dao;

import java.util.List;

import com.griter.model.dto.Image;

public interface ImageDao {
	// 이미지 등록
	int create(Image img);
	
	// 게시물 별 이미지
	List<Image> selectByPost(int post_id);
	
	// 이미지 삭제
	int delete(int image_id);
}
