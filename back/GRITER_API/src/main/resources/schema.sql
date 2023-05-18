CREATE DATABASE griter;
USE griter;

DROP TABLE IF EXISTS `users`;
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

DROP TABLE IF EXISTS `posts`;
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
    CONSTRAINT `fk_post_user`
		FOREIGN KEY (`user_id`)
		REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
    `image_id` INT AUTO_INCREMENT PRIMARY KEY,
    `img_path` VARCHAR(200) NOT NULL,
    `post_id` INT NOT NULL,
    CONSTRAINT `fk_image_post`
		FOREIGN KEY (`post_id`)
		REFERENCES `posts` (`post_id`)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS `comments`;
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
    	ON DELETE CASCADE,
    CONSTRAINT `fk_comment_post`
    	FOREIGN KEY (`post_id`)
    	REFERENCES `posts` (`post_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS `follows`;
CREATE TABLE IF NOT EXISTS `follows` (
    `follow_id` INT AUTO_INCREMENT PRIMARY KEY,
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

DROP TABLE IF EXISTS `post_likes`;
CREATE TABLE IF NOT EXISTS `post_likes`(
    `post_like_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `post_id` INT NOT NULL,
    CONSTRAINT `fk_postlikes_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES 	`users`(`user_id`)
    	ON DELETE CASCADE,
    CONSTRAINT `fk_postlikes_post`
    	FOREIGN KEY (`post_id`)
    	REFERENCES `posts` (`post_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS `comment_likes`;
CREATE TABLE IF NOT EXISTS `comment_likes` (
    `comment_like_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `comment_id` INT NOT NULL,
    CONSTRAINT `fk_commentlikes_user`
    	FOREIGN KEY (`user_id`)
    	REFERENCES `users` (`user_id`)
    	ON DELETE CASCADE,
    CONSTRAINT `fk_commentlikes_comment`
    	FOREIGN KEY (`comment_id`)
    	REFERENCES `comments` (`comment_id`)
    	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS `routines`;
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

DROP TABLE IF EXISTS `diets`;
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