package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.DietDao;
import com.griter.model.dto.Diet;

@Service
public class DietServiceImpl implements DietService {

	@Autowired
	private DietDao dietDao;
	
	@Override
	public int create(Diet diet) {
		return dietDao.create(diet);
	}

	@Override
	public List<Diet> selectAll() {
		return dietDao.selectAll();
	}

	@Override
	public Diet select(int diet_id) {
		return dietDao.select(diet_id);
	}

	@Override
	public List<Diet> selectByUser(int user_id) {
		return dietDao.selectByUser(user_id);
	}
	
	@Override
	public List<Diet> selectByDate(int date) {
		return dietDao.selectByDate(date);
	}

	@Override
	public int update(Diet diet) {
		return dietDao.update(diet);
	}

	@Override
	public int delete(int diet_id) {
		return dietDao.delete(diet_id);
	}
}
