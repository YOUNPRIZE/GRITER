package com.griter.model.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griter.model.dao.UserDao;
import com.griter.model.dto.User;
import com.griter.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDao userDao;

	@Override
	public int create(User user) {
		return userDao.create(user);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public User selectById(int user_id) {
		return userDao.selectById(user_id);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int delete(int user_id) {
		return userDao.delete(user_id);
	}

	@Override
	public User signIn(String nickname, String password) throws UnsupportedEncodingException {
		User user = null;
		List<User> all = userDao.selectAll();
		for (User u : all) {
			if (u.getNickname().equals(nickname) && u.getPassword().equals(password)) {
				user = u;
				break;
			}
		}
		System.out.println("userasdf: " + user);
		if (user != null) {
			String authToken = jwtUtil.createToken(user);
			user.setAuthToken(authToken);
			return user;
		} else {
			throw new RuntimeException("아이디 또는 비밀번호가 올바르지 않습니다.");
		}
	}

}
