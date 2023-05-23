package com.griter.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DietDto : 식단 정보", description = "식단 정보를 나타낸다.")
public class Diet {
	@ApiModelProperty(value = "식단 고유번호", example="0")
	private int diet_id;
	
	@ApiModelProperty(value = "사용자 ID", example="0")
	private int user_id;
	
	@ApiModelProperty(value = "날짜")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ApiModelProperty(value = "식사 (아침, 점심, 저녁, 간식)")
	private String meal;
	
	@ApiModelProperty(value = "식사 종류")
	private String kind;
	
	@ApiModelProperty(value = "섭취한 음식의 무게", example="0")
	private int gram;
	
	@ApiModelProperty(value = "섭취한 음식의 칼로리", example="0")
	private int calories;
	
	public Diet() {}

	public Diet(int diet_id, int user_id, Date date, String meal, String kind, int gram, int calories) {
		super();
		this.diet_id = diet_id;
		this.user_id = user_id;
		this.date = date;
		this.meal = meal;
		this.kind = kind;
		this.gram = gram;
		this.calories = calories;
	}

	public int getDiet_id() {
		return diet_id;
	}

	public void setDiet_id(int diet_id) {
		this.diet_id = diet_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getGram() {
		return gram;
	}

	public void setGram(int gram) {
		this.gram = gram;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Diet [diet_id=" + diet_id + ", user_id=" + user_id + ", date=" + date + ", meal=" + meal + ", kind="
				+ kind + ", gram=" + gram + ", calories=" + calories + "]";
	}
}
