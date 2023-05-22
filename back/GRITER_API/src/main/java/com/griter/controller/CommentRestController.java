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

import com.griter.model.dto.Comment;
import com.griter.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

// Comment
@RestController
@RequestMapping("/api/posts/comments")
@CrossOrigin("*")
public class CommentRestController {
	@Autowired
	private CommentService cs;

	@PostMapping("/")
	@ApiOperation(value = "댓글 등록", response = Comment.class)
	public ResponseEntity<?> create(Comment comment) {
		try {
			int create = cs.create(comment);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "사용자가 작성한 댓글 조회", response = Comment.class)
	public ResponseEntity<?> selectByUser(int user_id) {
		try {
			List<Comment> list = cs.selectByUser(user_id);
			return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{post_id}")
	@ApiOperation(value = "게시물에 등록된 댓글 조회", response = Comment.class)
	public ResponseEntity<?> selectByPost(@PathVariable int post_id) {
		try {
			List<Comment> list = cs.selectByPost(post_id);
			return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 대댓글
	
	@PutMapping("/")
	@ApiOperation(value = "댓글 수정", response = Comment.class)
	public ResponseEntity<?> update(Comment comment) {
		try {
			int update = cs.update(comment);
			return new ResponseEntity<Integer>(update, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{comment_id}")
	@ApiOperation(value = "댓글 삭제", response = Comment.class)
	public ResponseEntity<?> delete(@PathVariable int comment_id) {
		try {
			int delete = cs.delete(comment_id);
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
