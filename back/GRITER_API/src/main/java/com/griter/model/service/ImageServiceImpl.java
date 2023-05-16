package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.ImageDao;
import com.griter.model.dto.Image;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public void create(Image img) {
		imageDao.create(img);
	}

	@Override
	public List<Image> selectByPost(int post_id) {
		return imageDao.selectByPost(post_id);
	}

	@Override
	public int delete(int image_id) {
		return imageDao.delete(image_id);
	}
	

}
