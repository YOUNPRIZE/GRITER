package com.griter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.dto.Routine;
import com.griter.model.service.RoutineService;

import io.swagger.annotations.ApiOperation;

// Routine
@RestController
@RequestMapping("/api/routines")
@CrossOrigin("*")
public class RoutineRestController {
	// 의존성 주입
	@Autowired
	private RoutineService rs;

	@PostMapping("/")
	@ApiOperation(value = "운동 루틴 등록", response = Routine.class)
	public ResponseEntity<?> createRoutine(Routine routine) {
		try {
			int create = rs.create(routine);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "모든 운동 루틴 조회", response = Routine.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<Routine> select = rs.selectAll();
			return new ResponseEntity<List<Routine>>(select, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/{date}")
	@ApiOperation(value = "해당 날짜의 운동 루틴 조회", response = Routine.class)
	public ResponseEntity<?> selectRoutineByDate(@PathVariable int date) {
		try {
			List<Routine> select = rs.selectByDate(date);
			return new ResponseEntity<List<Routine>>(select, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/")
	@ApiOperation(value = "운동 루틴 수정", response = Routine.class)
	public ResponseEntity<?> updateRoutine(Routine routine) {
		try {
			int update = rs.update(routine);
			return new ResponseEntity<Integer>(update, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/{routine_id}")
	@ApiOperation(value = "운동 루틴 삭제", response = Routine.class)
	public ResponseEntity<?> deleteRoutine(@PathVariable int routine_id) {
		try {
			int delete = rs.delete(routine_id);
			return new ResponseEntity<Integer>(delete, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// ***************************************Exception***************************************
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// ***************************************************************************************

}
