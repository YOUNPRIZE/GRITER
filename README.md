# 🏋️‍♂️ GRITER

## **0️⃣ 프로젝트 개요**

🎈 프로젝트명 : 그리터(GRITER)

📌 프로젝트 컨셉 : 커뮤니티 기능과 운동 및 식단 정보 기록을 통해 건강 관리를 도와주는 서비스

🛠 개발 기간 : 23.05.18 ~ 23.05.25 (8일)

🧑🏻 팀원 : 박재민, 조윤상

💻 사용 기술스택

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">   

## **1️⃣ 프로젝트 일정**

![GANTT CHART](https://github.com/YOUNPRIZE/GRITER/assets/76830587/3df3ea7f-5403-4686-84cb-cf681c89dfd6)

## **1️⃣ 팀원 정보 및 업무 분담 내역**

| 이름   | 역할 | 설명           |
| ------ | ---- | -------------- |
| 박재민 | FE && BE    | Vue Component 설계 및 전반적인 프론트엔드 구현 + 백엔드 검토 |
| 조윤상 | BE && FE  | SpringBoot REST API 설계 및 백엔드 구현 + 프론트엔드 검토 |

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
  ![ERD](https://github.com/YOUNPRIZE/GRITER/assets/76830587/fc264cf0-f9d8-48a7-b3b3-594bf9dad94e)

## **5️⃣ 컴포넌트 구조**

📱 FrontEnd
```javascript
📄 .gitignore
📄 babel.config.js
📄 jsconfig.json
📄 package-lock.json
📄 package.json
📄 README.md
📄 vue.config.js
📂 node_modules
📂 public
    ㄴ📄 favicon.ico
    ㄴ📄 index.html
📂 src
    ㄴ📄 App.vue
    ㄴ📄 main.js
    ㄴ📂 assets
    ㄴ📂 components
    	ㄴ📄 HomeContent.vue
    	ㄴ📂 cals
	    ㄴ📄 CalCreate.vue
	    ㄴ📄 CalDetail.vue
	    ㄴ📄 CalDietCreate.vue
	    ㄴ📄 CalDietDetail.vue
	    ㄴ📄 CalList.vue
	ㄴ📂 common
	    ㄴ📄 AsideNav.vue
	ㄴ📂 posts
	    ㄴ📄 PostsCreate.vue
	    ㄴ📄 PostsDetail.vue
	    ㄴ📄 PostsList.vue
	ㄴ📂 users
	    ㄴ📄 UsersInfo.vue
	    ㄴ📄 UsersLogin.vue
	    ㄴ📄 UsersModify.vue
	    ㄴ📄 UsersRegister.vue
	    ㄴ📄 UsersSearch.vue
    ㄴ📂 router
    	ㄴ📄 index.js
    ㄴ📂 store
        ㄴ📄 store.js
	ㄴ📂 modules
	    ㄴ📄 commentModule.js
	    ㄴ📄 dietModule.js
	    ㄴ📄 followModule.js
	    ㄴ📄 nightmodeModule.js
	    ㄴ📄 postModule.js
	    ㄴ📄 routineModule.js
	    ㄴ📄 userModule.js
    ㄴ📂 util
        ㄴ📄 http-common.js
    ㄴ📂 views
    	ㄴ📄 CalView.vue
	ㄴ📄 HomeView.vue
	ㄴ📄 PostsView.vue
	ㄴ📄 UserView.vue
```
💾 BackEnd
```java
📂 src/main/java
	ㄴ📦 com.griter
		ㄴ📄 GriterApiApplication.java
	ㄴ📦 com.griter.config
		ㄴ📄 DBConfig.java
		ㄴ📄 SwaggerConfig.java
		ㄴ📄 WebConfing.java
	ㄴ📦 com.griter.controller
		ㄴ📄 CommentLikeRestController.java		
		ㄴ📄 CommentRestController.java			
		ㄴ📄 DietRestController.java		
		ㄴ📄 FollowRestController.java		
		ㄴ📄 ImageRestController.java
		ㄴ📄 PostLikeRestController.java		
		ㄴ📄 PostRestController.java
    		ㄴ📄 RoutineRestController.java
		ㄴ📄 UserRestController.java
	ㄴ📦 com.griter.exception
		ㄴ📄 PostNotFoundException.java
	ㄴ📦 com.griter.interceptor
		ㄴ📄 JwtInterceptor.java
	ㄴ📦 com.griter.model.dao
	    	ㄴ📄 CommentDao.java
		ㄴ📄 CommentLikeDao.java
		ㄴ📄 DietDao.java
		ㄴ📄 FollowDao.java
		ㄴ📄 ImageDao.java
		ㄴ📄 PostDao.java
		ㄴ📄 PostLikeDao.java
		ㄴ📄 RoutineLikeDao.java
		ㄴ📄 UserDao.java
    	ㄴ📦 com.griter.model.dto
   	   	ㄴ📄 Comment.java
		ㄴ📄 CommentLike.java
		ㄴ📄 Diet.java
		ㄴ📄 Follow.java
		ㄴ📄 Image.java
		ㄴ📄 Post.java
		ㄴ📄 PostLike.java
		ㄴ📄 Routine.java
		ㄴ📄 User.java
    	ㄴ📦 com.griter.model.service
		ㄴ📄 CommentLikeService.java
		ㄴ📄 CommentLikeServiceImpl.java
		ㄴ📄 CommentService.java
		ㄴ📄 CommentServiceImpl.java
		ㄴ📄 DietService.java
		ㄴ📄 DietServiceImpl.java
		ㄴ📄 FollowService.java
		ㄴ📄 FollowServiceImpl.java
		ㄴ📄 ImageService.java
   	   	ㄴ📄 ImageServiceImpl.java
		ㄴ📄 PostLikeService.java
		ㄴ📄 PostLikeServiceImpl.java
		ㄴ📄 PostService.java
		ㄴ📄 PostServiceImpl.java
		ㄴ📄 RoutineService.java
		ㄴ📄 RoutineServiceImpl.java
		ㄴ📄 UserService.java
		ㄴ📄 UserServiceImpl.java
📂 src/main/resources
	ㄴ📂 mappers
		ㄴ📄 Comment.xml
		ㄴ📄 CommentLike.xml
		ㄴ📄 Diet.xml
		ㄴ📄 Follow.xml
		ㄴ📄 Image.xml
		ㄴ📄 Post.xml
		ㄴ📄 PostLike.xml
		ㄴ📄 Routine.xml
		ㄴ📄 User.xml
	ㄴ📄 application.properties
	ㄴ📄 schema.sql
📄 pom.xml
```
<br>

## **6️⃣ 서비스 대표 기능 및 실제 구현 화면**

<br>

## **7️⃣ 배포 서버 URL**

<br>

## **8️⃣ 기타 (느낀 점 및 후기)**

😎 박재민



😜 조윤상
