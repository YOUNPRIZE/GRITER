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