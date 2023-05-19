package com.griter.model.dao;

import java.util.List;
import com.griter.model.dto.Diet;

public interface DietDao {
	// 식단 등록
	int create(Diet diet);
	
	// 모든 식단 조회
	List<Diet> selectAll();
	
	// 해당 날짜의 식단 조회
	List<Diet> selectByDate(int date);
	
	// 식단 수정
	int update(Diet diet);
	
	// 식단 삭제
	int delete(int diet_id);
}
