package com.griter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.service.PostService;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.griter.model.dto.User;
//import com.griter.model.service.CommentLikeService;
//import com.griter.model.service.CommentService;
//import com.griter.model.service.ImageService;
//import com.griter.model.service.PostLikeService;
//import com.griter.model.service.PostService;
//
//import io.swagger.annotations.ApiOperation;

// Post
@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostRestController {
	// 의존성 주입
	@Autowired
	private PostService ps;

	// ****************************************Post*******************************************
//	@PostMapping("/")
//	@ApiOperation(value = "게시물을 등록한다.", response = Post.class)
//	
//	@GetMapping("/")
//	@ApiOperation(value = "전체 게시물을 조회한다.", response = Post.class)
//	
//	@GetMapping("/category/{category}")
//	@ApiOperation(value = "카테고리별 게시물을 조회한다.", response = Post.class)
//	
//	@GetMapping("/{post_id}")
//	@ApiOperation(value = "게시물을 조회한다.", response = Post.class)
//	
//	@PutMapping("/")
//	@ApiOperation(value = "게시물을 수정한다.", response = Post.class)
//	
//	@DeleteMapping("/{post_id}]")
//	@ApiOperation(value = "게시물을 삭제한다.", response = Post.class)
	// ***************************************************************************************

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
