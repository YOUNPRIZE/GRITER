package com.griter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.service.ImageService;

// Image
@RestController
@RequestMapping("/posts/images")
@CrossOrigin("*")
public class ImageRestController {
	@Autowired
	private ImageService is;
	// ***************************************Image*******************************************
//	@PostMapping("/{post_id}/images")
//	@ApiOperation(value = "이미지를 등록한다.", response = Image.class)
//	
//	@GetMapping("/{post_id}/images")
//	@ApiOperation(value = "이미지를 조회한다.", response = Image.class)
//	
//	@PutMapping("/{post_id}/images")
//	@ApiOperation(value = "이미지를 수정한다.", response = Image.class)
//	
//	@DeleteMapping("/{post_id}/images")
//	@ApiOperation(value = "이미지를 삭제한다.", response = Image.class)
	// ***************************************************************************************

	// ***************************************Exception***************************************
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//
}
