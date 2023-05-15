# 🏋️‍♂️ GRITER

## **0️⃣ 프로젝트 개요**

- 프로젝트명 : 그리터(GRITER)
- 프로젝트 컨셉 :
- 개발 기간 : 23.05.15 ~ 23.05.25 (11일)
- 팀원 : 박재민, 조윤상
- 사용 기술스택 : SpringBoot, Java, Vue.js, JavaScript, MySQL, Ngrok
- <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">   

## **1️⃣ 팀원 정보 및 업무 분담 내역**

| 이름   | 역할 | 설명 |
| ------ | ---- | ---- |
| 박재민 | ?    | ?    |
| 조윤상 | ?    | ?    |

## **2️⃣ UI 디자인 및 프로토타입**

## **3️⃣ 목표 서비스 구현 및 실제 구현 정도**

## **4️⃣ 데이터베이스 모델링 (ERD)**

- start

  ```sql
  CREATE DATABASE griter;
  USE griter;
  
  DROP TABLE IF EXISTS posts;
  DROP TABLE IF EXISTS users;
  DROP TABLE IF EXISTS comments;
  DROP TABLE IF EXISTS follows;
  DROP TABLE IF EXISTS comment_likes;
  DROP TABLE IF EXISTS images;
  ```

- posts

  ```sql
  CREATE TABLE IF NOT EXISTS `posts` (
  		`post_id` INT AUTO_INCREMENT PRIMARY KEY,
  		`user_id` INT NOT NULL,
  		`title` VARCHAR(50) NOT NULL,
  		`content` TEXT NOT NULL,
  		`generated_date` VARCHAR(20) NOT NULL,
  		`modified_date` VARCHAR(20) NOT NULL,
  		`view_cnt` INT NOT NULL,
  		`like_cnt` INT NOT NULL,
  		`category` VARCHAR(50) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  // (댓글은 comment table에 외래키 걸기)
  // (사진은 comment table에 외래키 걸기 : 선택사항)
  ```

- users

  ```sql
  CREATE TABLE IF NOT EXISTS `users` (
  		`user_id` INT AUTO_INCREMENT PRIMARY KEY,
  		`password` VARCHAR(100) NOT NULL,
  		`email` VARCHAR(100) NOT NULL,
  		`gender` VARCHAR(10) NOT NULL,
  		`name` VARCHAR(20) NOT NULL,
  		`nickname` VARCHAR(20) NOT NULL,
  		`regist_date` VARCHAR(20) NOT NULL,
  		`image` VARCHAR(100)
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- comments

  ```sql
  CREATE TABLE IF NOT EXISTS `comments` (
  		`comment_id` INT AUTO_INCREMENT PRIMARY KEY,
  		`content` VARCHAR(200) NOT NULL,
  		`parent_id` INT, // 대댓글 기능
  		`user_id` INT NOT NULL, // 외래키
  		`post_id` INT NOT NULL // 외래키
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- follows

  ```sql
  CREATE TABLE IF NOT EXISTS `follows` (
  		`follow_id` INT AUTO_INCREMENT PRIMARY KEY,
  		`follower_id` INT NOT NULL, // 외래키
  		`user_id` INT NOT NULL // 외래키
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- comment_likes

  ```sql
  CREATE TABLE IF NOT EXISTS `comment_likes` (
  		`comment_like_id` INT AUTO_INCREMENT PRIMARY KEY,
  		`user_id` INT NOT NULL,
  		`comment_id` INT NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- images

  ```sql
  CREATE TABLE IF NOT EXISTS `images` (
  		`image_id` INT AUTO_INCREMENT PRIMARY KEY,
  		`img_path` VARCHAR(200) NOT NULL,
  		`post_id` INT NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

## **5️⃣ 컴포넌트 구조**

## **6️⃣ 서비스 대표 기능 및 실제 구현 화면**

## **7️⃣ 배포 서버 URL**

## **8️⃣ 기타 (느낀 점 및 후기)**