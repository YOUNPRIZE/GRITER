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

import com.griter.model.dto.Follow;
import com.griter.model.service.FollowService;

import io.swagger.annotations.ApiOperation;

// Follow
@RestController
@RequestMapping("/follows")
@CrossOrigin("*")
public class FollowRestController {
	@Autowired
	private FollowService fs;
	
	@PostMapping("/")
	@ApiOperation(value = "팔로우 신청", response = Follow.class)
	public ResponseEntity<?> createFollow(Follow follow) {
		try {
			int create = fs.createFollow(follow);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/following/{user_id}")
	@ApiOperation(value = "현재 사용자가 팔로우하는 사용자들을 조회", response = Follow.class)
	public ResponseEntity<?> selectByUserId(@PathVariable int user_id) {
		try {
			List<Follow> select = fs.selectByUserId(user_id);
			return new ResponseEntity<List<Follow>>(select, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/followed/{followed_id}")
	@ApiOperation(value = "현재 사용자를 팔로우하는 사용자들을 조회", response = Follow.class)
	public ResponseEntity<?> selectByFollowedId(@PathVariable int followed_id) {
		try {
			List<Follow> select = fs.selectByFollowedId(followed_id);
			return new ResponseEntity<List<Follow>>(select, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/unfollow")
	@ApiOperation(value = "팔로우 취소", response = Follow.class)
	public ResponseEntity<?> deleteFollow(Follow follow) {
		try {
			int delete = fs.deleteFollow(follow);
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
	// ***************************************************************************************

}
