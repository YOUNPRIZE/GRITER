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

import com.griter.model.dto.PostLike;
import com.griter.model.service.PostLikeService;

import io.swagger.annotations.ApiOperation;

// PostLike
@RestController
@RequestMapping("/api/posts/likes")
@CrossOrigin("*")
public class PostLikeRestController {
	// 의존성 주입
	@Autowired
	private PostLikeService pls;

	@PostMapping("/{post_id}")
	@ApiOperation(value = "게시물에 대한 좋아요 정보를 등록", response = PostLike.class)
	public ResponseEntity<?> create(PostLike postlike) {
		try {
			int create = pls.create(postlike);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/user/{user_id}")
	@ApiOperation(value = "사용자가 좋아요를 누른 게시물 정보를 조회", response = PostLike.class)
	public ResponseEntity<?> selectByUser(@PathVariable int user_id) {
		try {
			List<PostLike> list = pls.selectByUser(user_id);
			return new ResponseEntity<List<PostLike>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{post_id}")
	@ApiOperation(value = "게시물에 대한 좋아요 정보를 조회", response = PostLike.class)
	public ResponseEntity<?> selectByPost(@PathVariable int post_id) {
		try {
			List<PostLike> list = pls.selectByPost(post_id);
			return new ResponseEntity<List<PostLike>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/{post_id}")
	@ApiOperation(value = "게시물에 대한 좋아요 정보를 삭제", response = PostLike.class)
	public ResponseEntity<?> delete(PostLike postlike) {
		System.out.println(postlike);
		try {
			int delete = pls.delete(postlike);
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
