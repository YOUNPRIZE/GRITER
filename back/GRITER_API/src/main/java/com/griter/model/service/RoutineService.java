package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Routine;

public interface RoutineService {
	// 운동 루틴 등록
	int create(Routine routine);

	// 모든 운동 루틴 조회
	List<Routine> selectAll();
	
	// 특정 운동 루틴 조회
	Routine select(int routine_id);
	
	// 특정 사용자의 운동 루틴 조회
	List<Routine> selectByUser(int user_id);

	// 해당 날짜의 운동 루틴 조회
	List<Routine> selectByDate(int date);

	// 운동 루틴 수정
	int update(Routine routine);

	// 운동 루틴 삭제
	int delete(int routine_id);
}
