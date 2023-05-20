package com.griter.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.griter.model.dto.User;
import com.griter.model.service.UserService;

import io.swagger.annotations.ApiOperation;

// User
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserRestController {
	// 의존성 주입
	@Autowired
	private UserService us;
	
	@Autowired
	ResourceLoader resLoader;

	@PostMapping("/")
	@ApiOperation(value = "사용자 정보를 등록한다.", response = User.class)
	public ResponseEntity<?> create(User user, @RequestPart(required=false) MultipartFile file) {
		try {
			
			if (file != null && file.getSize() > 0) {
//				Resource res = resLoader.getResource("classpath:/static/resources/upload");
				Resource res = resLoader.getResource("/");
				System.out.println(res);
				user.setImage(System.currentTimeMillis() + "_" + file.getOriginalFilename());
				
				user.setOrgImage(file.getOriginalFilename());
				System.out.println(user.getImage());
				file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + user.getImage()));
			}
			int create = us.create(user);
			return new ResponseEntity<Integer>(create, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<User> list = us.selectAll();
			System.out.println(us.selectAll());
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/{nickname}")
	@ApiOperation(value = "{nickname}에 해당하는 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> select(@PathVariable String nickname) {
		try {
			User user = us.selectByNickname(nickname);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/")
	@ApiOperation(value = "사용자 정보를 수정한다.", response = User.class)
	public ResponseEntity<?> update(User user) {
		try {
			int update = us.update(user);
			return new ResponseEntity<Integer>(update, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/{user_id}")
	@ApiOperation(value = "{nickname}에 해당하는 사용자 정보를 삭제한다.", response = User.class)
	public ResponseEntity<?> delete(@PathVariable int user_id) {
		try {
			int delete = us.delete(user_id);
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
