package com.griter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.service.CommentLikeService;

// CommentLike
@RestController
@RequestMapping("/posts/comments/likes")
@CrossOrigin("*")
public class CommentLikeRestController {
	@Autowired
	private CommentLikeService cls;

	// *************************************CommentLike***************************************
//		@PostMapping("/comments/{comment_id}/likes")
//		@ApiOperation(value = "댓글에 대한 좋아요 정보를 등록한다.", response = CommentLike.class)
	//
//		@GetMapping("/comments/{comment_id}/likes")
//		@ApiOperation(value = "댓글에 대한 좋아요 정보를 조회한다.", response = CommentLike.class)
	//
//		// 사용자별도 추가해야 함.
	//
//		@DeleteMapping("/comments/{comment_id}/likes")
//		@ApiOperation(value = "댓글에 대한 좋아요 정보를 삭제한다.", response = CommentLike.class)
	// ***************************************************************************************

	// ***************************************Exception***************************************
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//
}
