package com.griter.model.service;

import com.griter.model.dto.Image;

public interface ImageService {
	int create(Image img);
	
	Image selectByUser(int user_id);
	
	int changePic(Image img);
	
	int delete(int user_id);
}
