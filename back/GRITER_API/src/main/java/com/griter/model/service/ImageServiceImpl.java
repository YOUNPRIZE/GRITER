package com.griter.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.ImageDao;
import com.griter.model.dto.Image;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public int create(Image img) {
		return imageDao.create(img);
	}

	@Override
	public Image selectByUser(int user_id) {
		return imageDao.selectByUser(user_id);
	}

	@Override
	public int changePic(Image img) {
		return imageDao.changePic(img);
	}
	
	@Override
	public int delete(int image_id) {
		return imageDao.delete(image_id);
	}
}
