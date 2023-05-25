package com.griter.model.dao;

import com.griter.model.dto.Image;

public interface ImageDao {
	int create(Image img);
	
	Image selectByUser(int user_id);
	
	int changePic(Image img);
	
	int delete(int user_id);
}
