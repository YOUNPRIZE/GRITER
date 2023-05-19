package com.griter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griter.model.service.CommentService;

// Comment
@RestController
@RequestMapping("/posts/comments")
@CrossOrigin("*")
public class CommentRestController {
	@Autowired
	private CommentService cs;

	// **************************************Comment******************************************
//		@PostMapping("/comments")
//		@ApiOperation(value = "댓글을 등록한다.", response = Comment.class)
	//
//		@GetMapping("/comments/{post_id}")
//		@ApiOperation(value = "게시물에 등록된 댓글을 조회한다.", response = Comment.class)
	//
//		@PutMapping("/comments")
//		@ApiOperation(value = "댓글을 수정한다.", response = Comment.class)
	//
//		@DeleteMapping("/comments/{comment_id}")
//		@ApiOperation(value = "댓글을 삭제한다.", response = Comment.class)

	// ***************************************************************************************

	// ***************************************Exception***************************************
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//
}
