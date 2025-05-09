

CREATE TABLE `post_info_db` (
  `Post_num` int(11) NOT NULL AUTO_INCREMENT,
  `PostUser_Nickname` varchar(45) NOT NULL,
  `Post_title` varchar(45) DEFAULT NULL,
  `Post_details` varchar(2000) DEFAULT NULL,
  `View_of_this_Post` int(11) NOT NULL,
  `Num_of_GoodMark` int(11) NOT NULL,
  PRIMARY KEY (`Post_num`,`PostUser_Nickname`)
);


CREATE TABLE `user_info_db` (
  `Num` int(11) NOT NULL AUTO_INCREMENT,
  `User_name` varchar(10) NOT NULL,
  `User_id` varchar(30) NOT NULL,
  `User_Password` varchar(45) NOT NULL,
  `User_Nickname` varchar(45) NOT NULL,
  PRIMARY KEY (`Num`,`User_Nickname`)
);

