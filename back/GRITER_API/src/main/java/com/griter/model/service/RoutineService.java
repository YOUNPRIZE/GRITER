package com.griter.model.service;

import java.util.List;

import com.griter.model.dto.Routine;

public interface RoutineService {
	// 운동 루틴 등록
	void create(Routine routine);

	// 모든 운동 루틴 조회
	List<Routine> selectAll();

	// 해당 날짜의 운동 루틴 조회
	List<Routine> selectByDate(int date);

	// 운동 루틴 수정
	int update(Routine routine);

	// 운동 루틴 삭제
	int delete(Routine routine);
}
