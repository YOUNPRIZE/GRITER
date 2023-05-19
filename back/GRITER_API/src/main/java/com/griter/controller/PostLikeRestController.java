package com.griter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.service.PostLikeService;

// PostLike
@RestController
@RequestMapping("/posts/likes")
@CrossOrigin("*")
public class PostLikeRestController {
	// 의존성 주입
	@Autowired
	private PostLikeService pls;
	// **************************************PostLike*****************************************
//		@PostMapping("/{post_id}/likes")
//		@ApiOperation(value = "게시물에 대한 좋아요 정보를 등록한다.", response = PostLike.class)
	//
//		@GetMapping("/{post_id}/likes")
//		@ApiOperation(value = "게시물에 대한 좋아요 정보를 조회한다.", response = PostLike.class)
	//
//		// 사용자별도 추가해야 함.
	//
//		@DeleteMapping("/{post_id}/likes")
//		@ApiOperation(value = "게시물에 대한 좋아요 정보를 삭제한다.", response = PostLike.class)

	// ***************************************************************************************

	// ***************************************Exception***************************************
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//
}
