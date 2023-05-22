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

import com.griter.model.dto.Diet;
import com.griter.model.service.DietService;

import io.swagger.annotations.ApiOperation;

// Diet
@RestController
@RequestMapping("/api/diets")
@CrossOrigin("*")
public class DietRestController {
	@Autowired
	private DietService ds;

	@PostMapping("/")
	@ApiOperation(value = "식단 등록", response = Diet.class)
	public ResponseEntity<?> createDiet(Diet diet) {
		try {
			int create = ds.create(diet);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "모든 식단 조회", response = Diet.class)
	public ResponseEntity<?> selectAllDiets() {
		try {
			List<Diet> select = ds.selectAll();
			return new ResponseEntity<List<Diet>>(select, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/{date}")
	@ApiOperation(value = "해당 날짜의 식단 조회", response = Diet.class)
	public ResponseEntity<?> selectDietByDate(@PathVariable int date) {
		try {
			List<Diet> select = ds.selectByDate(date);
			return new ResponseEntity<List<Diet>>(select, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/")
	@ApiOperation(value = "식단 수정", response = Diet.class)
	public ResponseEntity<?> updateDiet(Diet diet) {
		try {
			int update = ds.update(diet);
			return new ResponseEntity<Integer>(update, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/{diet_id}")
	@ApiOperation(value = "식단 삭제", response = Diet.class)
	public ResponseEntity<?> deleteDiet(@PathVariable int diet_id) {
		try {
			int delete = ds.delete(diet_id);
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
