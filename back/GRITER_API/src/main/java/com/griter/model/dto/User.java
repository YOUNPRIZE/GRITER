package com.griter.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto : 사용자 정보", description = "사용자의 정보를 나타낸다.")
public class User {
	@ApiModelProperty(value = "아이디")
	private int user_id;

	@ApiModelProperty(value = "비밀번호")
	private String password;

	@ApiModelProperty(value = "이메일")
	private String email;

	@ApiModelProperty(value = "성별")
	private String gender;

	@ApiModelProperty(value = "이름")
	private String name;

	@ApiModelProperty(value = "닉네임")
	private String nickname;

	@ApiModelProperty(value = "등록일")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date regist_date;

	@ApiModelProperty(value = "프로필 사진")
	private String image;

	private String orgImage;
	
	private String authToken;
	
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	private String refreshToken;

	public User(int user_id, String password, String email, String gender, String name, String nickname,
			Date regist_date, String image, String orgImage, String authToken, String refreshToken) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.name = name;
		this.nickname = nickname;
		this.regist_date = regist_date;
		this.image = image;
		this.orgImage = orgImage;
		this.authToken = authToken;
		this.refreshToken = refreshToken;
	}

	public User() {
	}

	public User(int user_id, String password, String email, String gender, String name, String nickname,
			Date regist_date, String image) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.name = name;
		this.nickname = nickname;
		this.regist_date = regist_date;
		this.image = image;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOrgImage() {
		return orgImage;
	}

	public void setOrgImage(String orgImage) {
		this.orgImage = orgImage;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", name=" + name + ", nickname=" + nickname + ", regist_date=" + regist_date + ", image=" + image
				+ "]";
	}
}
