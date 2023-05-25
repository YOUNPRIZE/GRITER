package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Diet;

public interface DietService {
	// 식단 등록
	int create(Diet diet);

	// 모든 식단 조회
	List<Diet> selectAll();

	// 특정 식단 조회
	Diet select(int diet_id);
		
	// 특정 사용자의 식단 조회
	List<Diet> selectByUser(int user_id);
	
	// 해당 날짜의 식단 조회
	List<Diet> selectByDate(int date);

	// 식단 수정
	int update(Diet diet);

	// 식단 삭제
	int delete(int diet_id);
}
