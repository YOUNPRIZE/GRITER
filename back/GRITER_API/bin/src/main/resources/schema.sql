CREATE DATABASE griter;
USE griter;

# USER TABLE
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 user ID 값
    `nickname` VARCHAR(20) NOT NULL UNIQUE, # ID
    `password` VARCHAR(100) NOT NULL, # 비밀번호
    `name` VARCHAR(20) NOT NULL, # 이름
    `email` VARCHAR(100) NOT NULL, # 이메일
    `gender` VARCHAR(10) NOT NULL, # 성별
    `regist_date` DATE DEFAULT (CURRENT_DATE), # 생성일 ex) 2023-05-19
    `image` VARCHAR(100) DEFAULT NULL # 프로필 사진
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT USER DUMMY DATA
INSERT INTO users (user_id, nickname, password, name, email, gender, regist_date, image) 
values (0, "catbirdseat", "1234", "박재민", "catbirdseat@gmail.com", "M", DEFAULT, DEFAULT),
(0, "younprize", "1234", "조윤상", "ysang10@gmail.com", "M", DEFAULT, DEFAULT),
(0, "edujihye", "1234", "오지혜", "edujihye@gmail.com", "W", DEFAULT, DEFAULT);

DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
    `post_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 post ID 값
    `user_id` INT NOT NULL, # 작성자 ID
    `title` VARCHAR(50) NOT NULL, # 제목
    `content` TEXT NOT NULL, # 내용
    `generated_date` DATETIME DEFAULT (CURRENT_TIMESTAMP) NOT NULL, # 작성일
    `modified_date` DATETIME DEFAULT (CURRENT_TIMESTAMP) NOT NULL, # 수정일 (작성 시에는 작성일과 수정일이 같음)
    `view_cnt` INT DEFAULT 0 NOT NULL, # 조회수
    `like_cnt` INT DEFAULT 0 NOT NULL, # 좋아요 수
    `category` VARCHAR(50) NOT NULL, # 카테고리
    CONSTRAINT `fk_post_user`
		FOREIGN KEY (`user_id`)
		REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT POST DUMMY DATA
INSERT INTO posts (post_id, user_id, title, content, generated_date, modified_date, view_cnt, like_cnt, category) 
values (0, 1, "아침 운동 깜빡했다..", "내일은 꼭 간다!!", DEFAULT, DEFAULT, DEFAULT, DEFAULT, "자유"),
(0, 2, "배고파..", "10층 가야지!", DEFAULT, DEFAULT, DEFAULT, DEFAULT, "자유"),
(0, 3, "안녕하세요~", "1시 15분까지 꼭 오세요!!", DEFAULT, DEFAULT, DEFAULT, DEFAULT, "자유");

DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
    `image_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 image ID 값
    `post_id` INT NOT NULL, # 게시물 ID
    `img_path` VARCHAR(200) NOT NULL, # image 경로
    CONSTRAINT `fk_image_post`
		FOREIGN KEY (`post_id`)
		REFERENCES `posts` (`post_id`)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
    `comment_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 comment ID 값
    `post_id` INT NOT NULL, # 게시물 ID
    `user_id` INT NOT NULL, # 사용자 ID
    `content` VARCHAR(200) NOT NULL, # 댓글 내용
    `parent_id` INT DEFAULT NULL, # 대댓글
    `generated_date` DATETIME DEFAULT (CURRENT_TIMESTAMP) NOT NULL, # 작성일
    `modified_date` DATETIME DEFAULT (CURRENT_TIMESTAMP) NOT NULL, # 수정일
    CONSTRAINT `fk_comment_post`
    	FOREIGN KEY (`post_id`)
    	REFERENCES `posts` (`post_id`)
    	ON DELETE CASCADE,
    CONSTRAINT `fk_comment_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT COMMENT DUMMY DATA
INSERT INTO comments (comment_id, post_id, user_id, content, parent_id, generated_date, modified_date) 
values (0, 1, 2, "같이 갈텨???", 0, DEFAULT, DEFAULT),
(0, 1, 3, "다치지 마세요~", 0, DEFAULT, DEFAULT),
(0, 2, 1, "샌드위치 먹을거야?", 0, DEFAULT, DEFAULT),
(0, 2, 3, "같이 10층 가요!", 0, DEFAULT, DEFAULT),
(0, 3, 1, "아빠 왔다~", 0, DEFAULT, DEFAULT),
(0, 3, 2, "안녕하세요 x 10", 0, DEFAULT, DEFAULT);

DROP TABLE IF EXISTS `follows`;
CREATE TABLE IF NOT EXISTS `follows` (
    `follow_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 follow ID 값
    `user_id` INT NOT NULL, # 외래키 날 팔로우 하는 사람
    `following_id` INT NOT NULL, # 외래키 내가 팔로우 하는 사람
    CONSTRAINT `fk_follows_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE,
    CONSTRAINT `fk_follows_following`
    	FOREIGN KEY (`following_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT FOLLOW DUMMY DATA
INSERT INTO follows (follow_id, user_id, following_id) 
values (0, 1, 3),
(0, 2, 3),
(0, 1, 2),
(0, 2, 1);

DROP TABLE IF EXISTS `post_likes`;
CREATE TABLE IF NOT EXISTS `post_likes`(
    `post_like_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 postLike ID 값
    `user_id` INT NOT NULL, # 사용자
    `post_id` INT NOT NULL, # 게시물
    CONSTRAINT `fk_postlikes_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES 	`users`(`user_id`)
    	ON DELETE CASCADE,
    CONSTRAINT `fk_postlikes_post`
    	FOREIGN KEY (`post_id`)
    	REFERENCES `posts` (`post_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT POST_LIKE DUMMY DATA
INSERT INTO post_likes (post_like_id, user_id, post_id) 
values (0, 1, 1),
(0, 1, 2),
(0, 1, 3),
(0, 2, 1),
(0, 2, 2),
(0, 2, 3),
(0, 3, 1),
(0, 3, 2),
(0, 3, 3);

DROP TABLE IF EXISTS `comment_likes`;
CREATE TABLE IF NOT EXISTS `comment_likes` (
    `comment_like_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 commentLike ID 값
    `user_id` INT NOT NULL, # 사용자
    `comment_id` INT NOT NULL, # 댓글
    CONSTRAINT `fk_commentlikes_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE,
    CONSTRAINT `fk_commentlikes_comment`
    	FOREIGN KEY (`comment_id`)
    	REFERENCES `comments` (`comment_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT COMMENT_LIKE DUMMY DATA
INSERT INTO comment_likes (comment_like_id, user_id, comment_id) 
values (0, 1, 2),
(0, 1, 4),
(0, 1, 6),
(0, 2, 1),
(0, 2, 3),
(0, 2, 5),
(0, 3, 1),
(0, 3, 2),
(0, 3, 3);

DROP TABLE IF EXISTS `routines`;
CREATE TABLE IF NOT EXISTS `routines` (
    `routine_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 ID값, PK
    `user_id` INT NOT NULL,
    `exercise` VARCHAR(100) NOT NULL, # 운동 종류? 종목 ex) 달리기, 스쿼트
    `type` VARCHAR(100) NOT NULL, # ex) 유산소, 하체, 어깨, 이두 etc..
    `date` DATE DEFAULT (CURRENT_DATE) NOT NULL, # 운동한 날짜
    `time` INT DEFAULT NULL, # 운동 시간 (선택적?)
    `sets` INT DEFAULT NULL, # 유산소 운동 했을 경우 sets, reps, weight 필요 없으므로 NULLABLE
    `reps` INT DEFAULT NULL,
    `weight` INT DEFAULT NULL,
    CONSTRAINT `fk_routines_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT ROUTINE DUMMY DATA
INSERT INTO routines (routine_id, user_id, exercise, type, date, time, sets, reps, weight) 
values (0, 1, "달리기", "유산소", DEFAULT, 30, DEFAULT, DEFAULT, DEFAULT),
(0, 1, "스쿼트", "하체", DEFAULT, 50, 5, 5, 100);

DROP TABLE IF EXISTS `diets`;
CREATE TABLE IF NOT EXISTS `diets` (
    `diet_id` INT AUTO_INCREMENT PRIMARY KEY, # 고유 ID값, PK
    `user_id` INT NOT NULL,
    `date` DATE DEFAULT (CURRENT_DATE) NOT NULL, # 날짜
    `meal` VARCHAR(20) NOT NULL, # 아침, 점심, 저녁, 간식 등
    `kind` VARCHAR(100) NOT NULL, # 무슨 종류? 계란, 고구마 등등 입력
    `gram` INT DEFAULT 0, # 섭취한 음식의 무게
	`calories` INT DEFAULT 0, # 칼로리를 알 경우 입력되게??
    CONSTRAINT `fk_diets_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

# INSERT DIET DUMMY DATA
INSERT INTO diets (diet_id, user_id, date, meal, kind, gram, calories) 
values (0, 1, DEFAULT, "점심", "닭가슴살", 100, 200),
(0, 1, DEFAULT, "저녁", "족발", 200, 1000);