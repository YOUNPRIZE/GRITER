package com.griter.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RoutineDto : 운동 루틴 정보", description = "운동 루틴 정보를 나타낸다.")
public class Routine {
	@ApiModelProperty(value = "운동 루틴 고유번호", example="0")
	private int routine_id;
	
	@ApiModelProperty(value = "사용자 ID", example="0")
	private int user_id;
	
	@ApiModelProperty(value = "운동의 종류")
	private String exercise;
	
	@ApiModelProperty(value = "운동 타입")
	private String type;
	
	@ApiModelProperty(value = "날짜")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ApiModelProperty(value = "운동 시간", example="0")
	private int time;
	
	@ApiModelProperty(value = "세트 수", example="0")
	private int sets;
	
	@ApiModelProperty(value = "횟수", example="0")
	private int reps;
	
	@ApiModelProperty(value = "운동 중량", example="0")
	private int weight;
	
	public Routine() {}

	public Routine(int routine_id, int user_id, String exercise, String type, Date date, int time, int sets, int reps,
			int weight) {
		super();
		this.routine_id = routine_id;
		this.user_id = user_id;
		this.exercise = exercise;
		this.type = type;
		this.date = date;
		this.time = time;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
	}

	public int getRoutine_id() {
		return routine_id;
	}

	public void setRoutine_id(int routine_id) {
		this.routine_id = routine_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Routine [routine_id=" + routine_id + ", user_id=" + user_id + ", exercise=" + exercise + ", type="
				+ type + ", date=" + date + ", time=" + time + ", sets=" + sets + ", reps=" + reps + ", weight="
				+ weight + "]";
	}
}
