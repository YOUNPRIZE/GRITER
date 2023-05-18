package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Diet;

public interface DietService {
	// 식단 등록
	void create(Diet diet);

	// 모든 식단 조회
	List<Diet> selectAll();

	// 해당 날짜의 식단 조회
	List<Diet> selectByDate(int date);

	// 식단 수정
	int update(Diet diet);

	// 식단 삭제
	int delete(int diet_id);
}