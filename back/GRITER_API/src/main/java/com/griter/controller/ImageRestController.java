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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.griter.model.dto.Image;
import com.griter.model.dto.User;
import com.griter.model.service.ImageService;
import com.griter.model.service.UserService;

import io.swagger.annotations.ApiOperation;

// Image
@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
public class ImageRestController {
	@Autowired
	private ImageService is;
	
	@Autowired
	private UserService us;
	
	@Autowired
	ResourceLoader resLoader;

	@PostMapping("/{nickname}/{data}")
	@ApiOperation(value = "이미지 등록", response = Image.class)
	public ResponseEntity<?> create(@PathVariable String nickname, @PathVariable MultipartFile data) {
		System.out.println(data);
		try {
			List<User> all = us.selectAll();
			int user_id = -1;
			for(User u : all) {
				if(u.getNickname().contentEquals(nickname)) {
					user_id = u.getUser_id();
				}
			}
			User user = us.selectById(user_id);
			Resource res = resLoader.getResource("resources/upload");
			user.setImage(user.getUser_id()+"_"+data.getOriginalFilename());
			user.setOrgImage(data.getOriginalFilename());
			us.update(user);
			data.transferTo(new File(res.getFile().getCanonicalPath()+"/"+user.getImage()));
	        return ResponseEntity.ok("Image uploaded successfully!");
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/{user_id}")
	@ApiOperation(value = "이미지 조회", response = Image.class)
	public ResponseEntity<?> selectByUser(@PathVariable int user_id) {
		try {
			Image img = is.selectByUser(user_id);
			return new ResponseEntity<Image>(img, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/modify/{user_id}")
	@ApiOperation(value = "이미지 수정", response = Image.class)
	public ResponseEntity<?> changePic(@PathVariable int user_id) {
		return null;
	}

	@DeleteMapping("/{post_id}")
	@ApiOperation(value = "이미지 삭제", response = Image.class)
	public ResponseEntity<?> delete(int image_id) {
		try {
			int delete = is.delete(image_id);
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
