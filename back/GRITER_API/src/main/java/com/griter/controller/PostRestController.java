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

import com.griter.model.dto.Post;
import com.griter.model.service.PostService;

import io.swagger.annotations.ApiOperation;

// Post
@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostRestController {
	// 의존성 주입
	@Autowired
	private PostService ps;

	@PostMapping("/")
	@ApiOperation(value = "게시물 등록", response = Post.class)
	public ResponseEntity<?> create(Post post) {
		try {
			int create = ps.create(post);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e){
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/")
	@ApiOperation(value = "전체 게시물 조회", response = Post.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<Post> list = ps.selectAll();
			return new ResponseEntity<List<Post>>(list, HttpStatus.OK);
		} catch (Exception e){
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/category/{category}")
	@ApiOperation(value = "카테고리별 게시물 조회", response = Post.class)
	public ResponseEntity<?> selectCategory(@PathVariable String category) {
		try {
			List<Post> list = ps.selectCategory(category);
			return new ResponseEntity<List<Post>>(list, HttpStatus.OK);
		} catch (Exception e){
			return exceptionHandling(e);
		}
	}
	
//	@GetMapping("/{post_id}")
//	@ApiOperation(value = "게시물을 조회한다.", response = Post.class)
	
	@PutMapping("/")
	@ApiOperation(value = "게시물 수정", response = Post.class)
	public ResponseEntity<?> update(Post post) {
		try {
			int update = ps.update(post);
			return new ResponseEntity<Integer>(update, HttpStatus.OK);
		} catch (Exception e){
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{post_id}")
	@ApiOperation(value = "게시물 삭제", response = Post.class)
	public ResponseEntity<?> delete(@PathVariable int post_id) {
		try {
			int delete = ps.delete(post_id);
			return new ResponseEntity<Integer>(delete, HttpStatus.OK);
		} catch (Exception e){
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
