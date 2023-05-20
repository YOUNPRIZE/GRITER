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

import com.griter.model.dto.CommentLike;
import com.griter.model.service.CommentLikeService;

import io.swagger.annotations.ApiOperation;

// CommentLike
@RestController
@RequestMapping("/posts/comments/likes")
@CrossOrigin("*")
public class CommentLikeRestController {
	@Autowired
	private CommentLikeService cls;

	@PostMapping("/{comment_id}")
	@ApiOperation(value = "댓글에 대한 좋아요 정보 등록", response = CommentLike.class)
	public ResponseEntity<?> create(CommentLike commentlike) {
		try {
			int create = cls.create(commentlike);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "사용자가 좋아요한 댓글 정보 조회", response = CommentLike.class)
	public ResponseEntity<?> selectByUser(int user_id) {
		try {
			List<CommentLike> list = cls.selectByUser(user_id);
			return new ResponseEntity<List<CommentLike>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{comment_id}")
	@ApiOperation(value = "댓글에 대한 좋아요 정보 조회", response = CommentLike.class)
	public ResponseEntity<?> selectByCommentId(@PathVariable int comment_id) {
		try {
			List<CommentLike> list = cls.selectByCommentId(comment_id);
			return new ResponseEntity<List<CommentLike>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{comment_id}")
	@ApiOperation(value = "댓글에 대한 좋아요 정보 삭제", response = CommentLike.class)
	public ResponseEntity<?> delete(int comment_like_id) {
		try {
			int delete = cls.delete(comment_like_id);
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
