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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.dto.Image;
import com.griter.model.service.ImageService;

import io.swagger.annotations.ApiOperation;

// Image
@RestController
@RequestMapping("/posts/images")
@CrossOrigin("*")
public class ImageRestController {
	@Autowired
	private ImageService is;
	@PostMapping("/{post_id}")
	@ApiOperation(value = "이미지 등록", response = Image.class)
	public ResponseEntity<?> create(Image img) {
		try {
			int create = is.create(img);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{post_id}")
	@ApiOperation(value = "이미지 조회", response = Image.class)
	public ResponseEntity<?> selectByPost(@PathVariable int post_id) {
		try {
			List<Image> list = is.selectByPost(post_id);
			return new ResponseEntity<List<Image>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
//	@PutMapping("/{post_id}/images")
//	@ApiOperation(value = "이미지 수정", response = Image.class)
	
	@DeleteMapping("/{post_id}")
	@ApiOperation(value = "이미지 삭제", response = Image.class)
	public ResponseEntity<?> delete(int image_id) {
		try {
			int delete = is.delete(image_id);
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
	//
}
