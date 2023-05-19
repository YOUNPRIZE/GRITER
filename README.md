# 🏋️‍♂️ GRITER

## **0️⃣ 프로젝트 개요**

- 프로젝트명 : 그리터(GRITER)

- 프로젝트 컨셉 :

- 개발 기간 : 23.05.18 ~ 23.05.25 (8일)

- 팀원 : 박재민, 조윤상

- 사용 기술스택

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">   

## **1️⃣ 프로젝트 일정**

![GANTT CHART](https://github.com/YOUNPRIZE/GRITER/assets/76830587/3df3ea7f-5403-4686-84cb-cf681c89dfd6)

## **1️⃣ 팀원 정보 및 업무 분담 내역**

| 이름   | 역할 | 설명           |
| ------ | ---- | -------------- |
| 박재민 | ?    | 모찌모찌기모찌 |
| 조윤상 | ?    | ?              |

## **2️⃣ UI 디자인 및 프로토타입**

* 로그인
 
![LogIn](https://github.com/YOUNPRIZE/GRITER/assets/76830587/4965eccb-1000-4557-b880-fd4738cebd6a)

* 회원가입

![Sign Up](https://github.com/YOUNPRIZE/GRITER/assets/76830587/63ed5591-2209-40ce-96f1-ea77f5b20a58)

* 홈페이지
 
![Home](https://github.com/YOUNPRIZE/GRITER/assets/76830587/a17b99fb-dcb4-4ef1-8e9d-458d41540ebb)

* 게시판

![DashBoard](https://github.com/YOUNPRIZE/GRITER/assets/76830587/d9b4fb22-2817-493b-a7a6-2d8b9b23cd1d)

* 글 등록
 
![Post](https://github.com/YOUNPRIZE/GRITER/assets/76830587/6d6748fa-d49d-4756-92eb-582e5e5cf686)

* 글 상세
 
![Detail](https://github.com/YOUNPRIZE/GRITER/assets/76830587/361bfe15-3e1a-498e-9326-80b82264e91e)

* 마이 페이지
 
![MyPage](https://github.com/YOUNPRIZE/GRITER/assets/76830587/33ae3e32-8bbd-4bc2-bf39-1bf2dc163ea1)

* 달력

![Calender](https://github.com/YOUNPRIZE/GRITER/assets/76830587/b09a7aad-cd4e-4305-84d9-41a3ea1a701e)
<br>

<!--## **3️⃣ 목표 서비스 구현 및 실제 구현 정도** -->

## **3️⃣ 서비스 명세서**
- [API 명세서](https://circular-ear-098.notion.site/63605c790ee94654a969fbd19b5dc299?v=a80ec7fc2ccf42888ef39c8d1050ee3e)

## **4️⃣ 데이터베이스 모델링 (ERD)**
- ERD

  ![ERD](https://github.com/YOUNPRIZE/GRITER/assets/76830587/bcf615f4-7c10-4fa4-8322-d9792b100b4e)

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
      `image` VARCHAR(100) # 프로필 사진이 1개이므로 외래키 필요 X
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
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
      `category` VARCHAR(50) NOT NULL,
      `image` VARCHAR(100),
      CONSTRAINT `fk_post_user`
      FOREIGN KEY (`user_id`)
      REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
      CONSTRAINT `fk_post_image`
      FOREIGN KEY (`image`)
      REFERENCES `images` (`post_id`)
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- comments

  ```sql
  CREATE TABLE IF NOT EXISTS `comments` (
      `comment_id` INT AUTO_INCREMENT PRIMARY KEY,
      `content` VARCHAR(200) NOT NULL,
      `parent_id` INT, # 대댓글 기능
      `user_id` INT NOT NULL,
      `post_id` INT NOT NULL,
      `generated_date` VARCHAR(20) NOT NULL,
      `modified_date` VARCHAR(20) NOT NULL,
      CONSTRAINT `fk_comment_user`
      	FOREIGN KEY (`user_id`)
      	REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
      CONSTRAINT `fk_comment_post`
      	FOREIGN KEY (`post_id`)
      	REFERENCES `posts` (`post_id`)
      	ON DELETE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- follows

  ```sql
  CREATE TABLE IF NOT EXISTS `follows` (
      `follow_id` INT AUTO_INCREMENT PRIMARY KEY,
      `user_id` INT NOT NULL, # 외래키 날 팔로우 하는 사람
      `following_id` INT NOT NULL, # 외래키 내가 팔로우 하는 사람
      CONSTRAINT `fk_follows_user`
      	FOREIGN KEY (`user_id`)
      	REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
      CONSTRAINT `fk_follows_following`
      	FOREIGN KEY (`following_id`)
      	REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- post_likes

  ```sql
  CREATE TABLE IF NOT EXISTS `post_likes`(
      `post_like_id` INT AUTO_INCREMENT PRIMARY KEY,
      `user_id` INT NOT NULL,
      `post_id` INT NOT NULL,
      CONSTRAINT `fk_postlikes_user`
      	FOREIGN KEY (`user_id`)
      	REFERENCES 	`users`(`user_id`)
      	ON DELETE CASCADE
      CONSTRAINT `fk_postlikes_post`
      	FOREIGN KEY (`post_id`)
      	REFERENCES `posts` (`post_id`)
      	ON DELETE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- comment_likes

  ```sql
  CREATE TABLE IF NOT EXISTS `comment_likes` (
      `comment_like_id` INT AUTO_INCREMENT PRIMARY KEY,
      `user_id` INT NOT NULL,
      `comment_id` INT NOT NULL,
      CONSTRAINT `fk_commentlikes_user`
      	FOREIGN KEY (`user_id`)
      	REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
      CONSTRAINT `fk_commentlikes_comment`
      	FOREIGN KEY (`comment_id`)
      	REFERENCES `comments` (`comment_id`)
      	ON DELETE CASCADE
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

- routines

  ```sql
  CREATE TABLE IF NOT EXISTS `routines` (
      `routine_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 ID값, PK
      `user_id` INT NOT NULL,
      `exercise` VARCHAR(100) NOT NULL, # 운동 종류? 종목 ex) 달리기, 스쿼트
      `type` VARCHAR(100) NOT NULL, # ex) 유산소, 하체, 어깨, 이두 etc..
      `date` DATE NOT NULL, # 운동한 날짜
      `time` INT, # 운동 시간 (선택적?)
      `sets` INT, # 유산소 운동 했을 경우 sets, reps, weight 필요 없으므로 NULLABLE
      `reps` INT,
      `weight` INT,
      CONSTRAINT `fk_routines_user`
      	FOREIGN KEY (`user_id`)
      	REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```

- diets

  ```sql
  CREATE TABLE IF NOT EXISTS `diets` (
      `diet_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 ID값, PK
      `user_id` INT NOT NULL,
      `date` DATE NOT NULL, # 날짜
      `meal` VARCHAR(20) NOT NULL, # 아침, 점심, 저녁, 간식 등
      `kind` VARCHAR(100) NOT NULL, # 무슨 종류? 계란, 고구마 등등 입력
      `gram` INT NOT NULL, # 섭취한 음식의 무게
  	`calories` INT, # 칼로리를 알 경우 입력되게??
      CONSTRAINT `fk_diets_user`
      	FOREIGN KEY (`user_id`)
      	REFERENCES `users` (`user_id`)
      	ON DELETE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
  ```
<br>

## **5️⃣ 컴포넌트 구조**

* FrontEnd

  

* BackEnd

```java
📂 src/main/java
	ㄴ📦 com.griter
		ㄴ📄 GriterApiApplication.java
	ㄴ📦 com.griter.config
		ㄴ📄 DBConfig.java
		ㄴ📄 SwaggerConfig.java
		ㄴ📄 WebConfing.java
	ㄴ📦 com.griter.controller
		ㄴ📄 PostRestController.java
    		ㄴ📄 UserRestController.java
	ㄴ📦 com.griter.exception
		ㄴ📄 PostNotFoundException.java
	ㄴ📦 com.griter.model.dao
	    	ㄴ📄 CommentDao.java
		ㄴ📄 CommentLikeDao.java
		ㄴ📄 FollowDao.java
		ㄴ📄 ImageDao.java
		ㄴ📄 PostDao.java
		ㄴ📄 PostLikeDao.java
		ㄴ📄 UserDao.java
    	ㄴ📦 com.griter.model.dto
   	   	ㄴ📄 Comment.java
		ㄴ📄 CommentLike.java
		ㄴ📄 Follow.java
		ㄴ📄 Image.java
		ㄴ📄 Post.java
		ㄴ📄 PostLike.java
		ㄴ📄 User.java
    	ㄴ📦 com.griter.model.service
		ㄴ📄 CommentLikeService.java
		ㄴ📄 CommentLikeServiceImpl.java
		ㄴ📄 CommentService.java
		ㄴ📄 CommentServiceImpl.java
		ㄴ📄 FollowService.java
		ㄴ📄 FollowServiceImpl.java
		ㄴ📄 ImageService.java
   	   	ㄴ📄 ImageServiceImpl.java
		ㄴ📄 PostLikeService.java
		ㄴ📄 PostLikeServiceImpl.java
		ㄴ📄 PostService.java
		ㄴ📄 PostServiceImpl.java
		ㄴ📄 UserService.java
		ㄴ📄 UserServiceImpl.java
📂 src/main/resources
	ㄴ📂 mappers
		ㄴ📄 Comment.xml
		ㄴ📄 CommentLike.xml
		ㄴ📄 Follow.xml
		ㄴ📄 Image.xml
		ㄴ📄 Post.xml
		ㄴ📄 PostLike.xml
		ㄴ📄 User.xml
		ㄴ📄 application.properties
📄 pom.xml
```
<br>

## **6️⃣ 서비스 대표 기능 및 실제 구현 화면**

<br>

## **7️⃣ 배포 서버 URL**

<br>

## **8️⃣ 기타 (느낀 점 및 후기)**

* 박재민



* 조윤상
