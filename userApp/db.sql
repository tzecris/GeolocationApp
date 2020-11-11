DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_line` varchar(45) NOT NULL,
  `address_no` int(11) NOT NULL,
  `zip_code` int(11) NOT NULL,
  `city` varchar(45) NOT NULL,
  `lng` double DEFAULT '0',
  `lat` double DEFAULT '0',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `afm` varchar(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`afm`),
  KEY `user_address_idx` (`address_id`),
  CONSTRAINT `user_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


