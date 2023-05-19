package com.griter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.RoutineDao;
import com.griter.model.dto.Routine;

@Service
public class RoutineServiceImpl implements RoutineService {

	@Autowired
	private RoutineDao routineDao;

	@Override
	public int create(Routine routine) {
		return routineDao.create(routine);
	}

	@Override
	public List<Routine> selectAll() {
		return routineDao.selectAll();
	}

	@Override
	public List<Routine> selectByDate(int date) {
		return routineDao.selectByDate(date);
	}

	@Override
	public int update(Routine routine) {
		return routineDao.update(routine);
	}

	@Override
	public int delete(int routine_id) {
		return routineDao.delete(routine_id);
	}

}
