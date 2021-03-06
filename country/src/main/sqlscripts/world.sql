﻿# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : world


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `world`;

CREATE DATABASE `world`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_unicode_ci';

USE `world`;

#
# Structure for the `authorities` table : 
#

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `country` table : 
#

CREATE TABLE `country` (
  `code` varchar(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `world_name` varchar(255) NOT NULL,
  `population` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `language` table : 
#

CREATE TABLE `language` (
  `name` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `country_translation` table : 
#

CREATE TABLE `country_translation` (
  `country_translation_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `local_name` varchar(255) NOT NULL,
  `capital` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`country_translation_id`),
  UNIQUE KEY `country_language_id` (`country_translation_id`),
  KEY `FK_63sm5uoj4j9btw05hy6sfwjef` (`code`),
  KEY `FK_thpq6h5hmjkyemuojhnxepkkj` (`name`),
  CONSTRAINT `FK_63sm5uoj4j9btw05hy6sfwjef` FOREIGN KEY (`code`) REFERENCES `country` (`code`),
  CONSTRAINT `FK_thpq6h5hmjkyemuojhnxepkkj` FOREIGN KEY (`name`) REFERENCES `language` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for the `oauth_access_token` table : 
#

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `oauth_client_details` table : 
#

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `oauth_client_token` table : 
#

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `oauth_code` table : 
#

CREATE TABLE `oauth_code` (
  `code` varchar(255) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `oauth_refresh_token` table : 
#

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `role` table : 
#

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for the `users` table : 
#

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `last_updated_by` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `preferred_language` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_dw8xe4vev0ok8rmwjuoexrbs6` (`preferred_language`),
  CONSTRAINT `FK_dw8xe4vev0ok8rmwjuoexrbs6` FOREIGN KEY (`preferred_language`) REFERENCES `language` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for the `user_role` table : 
#

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `country` table  (LIMIT 0,500)
#

INSERT INTO `country` (`code`, `created_by`, `date_created`, `last_updated`, `last_updated_by`, `world_name`, `population`) VALUES 
  ('EG','mkanchwala','2015-05-22 23:22:00','2015-05-22 23:22:00','mkanchwala','Egypt',120),
  ('IN','mkanchwala','2015-05-22 23:20:00','2015-05-22 23:20:00','mkanchwala','India',120);
COMMIT;

#
# Data for the `language` table  (LIMIT 0,500)
#

INSERT INTO `language` (`name`, `created_by`, `date_created`, `description`, `last_updated`, `last_updated_by`) VALUES 
  ('English','mkanchwala','2015-05-22 23:22:00','World Official Language','2015-05-22 23:22:00','mkanchwala'),
  ('Arabic','mkanchwala','2015-05-22 23:22:00','Arabian Language','2015-05-22 23:22:00','mkanchwala'),
  ('Misri','mkanchwala','2015-05-22 23:22:00','Egypt Native Language','2015-05-22 23:22:00','mkanchwala'),
  ('Hindi','mkanchwala','2015-05-22 23:20:00','India Native Langauge','2015-05-22 23:20:00','mkanchwala');
COMMIT;

#
# Data for the `country_translation` table  (LIMIT 0,500)
#

INSERT INTO `country_translation` (`country_translation_id`, `created_by`, `date_created`, `last_updated`, `last_updated_by`, `code`, `name`, `local_name`, `capital`, `description`) VALUES 
  (1,'mkanchwala','2015-05-22 23:20:00','2015-05-22 23:20:00','mkanchwala','IN','English','India','New Delhi','It is the seventh-largest country by area and the most populous democracy in the world'),
  (2,'mkanchwala','2015-05-22 23:20:00','2015-05-22 23:20:00','mkanchwala','IN','Arabic','الهند','نيودلهي','الهند أو كما يطلق عليها رسميا جمهورية الهند '),
  (3,'mkanchwala','2015-05-22 23:20:00','2015-05-22 23:20:00','mkanchwala','IN','Hindi','भारत','नई दिल्ली','दक्षिण एशिया में स्थित भारतीय उपमहाद्वीप का सबसे बड़ा देश है '),
  (4,'mkanchwala','2015-05-22 23:22:00','2015-05-22 23:22:00','mkanchwala','EG','English','Egypt','Cairo','Egypt is the most populous country in North Africa and the Arab World, the third-most populous in Africa, and the fifteenth-most populous in the world'),
  (5,'mkanchwala','2015-05-22 23:22:00','2015-05-22 23:22:00','mkanchwala','EG','Misri','مصر','القاهره','بلادي، بلادي، بلادي');

COMMIT;

#
# Data for the `role` table  (LIMIT 0,500)
#

INSERT INTO `role` (`id`, `name`) VALUES 
  (1,'ROLE_USER'),
  (2,'ROLE_ADMIN'),
  (3,'ROLE_GUEST');
COMMIT;

#
# Data for the `users` table  (LIMIT 0,500)
#

INSERT INTO `users` (`user_id`, `created_by`, `date_created`, `email`, `enabled`, `last_updated`, `last_updated_by`, `password`, `username`, `preferred_language`) VALUES 
  (1,'mkanchwala','2015-05-22 23:20:00','imkanchwala@gmail.com',1,'2015-05-22 23:20:00','mkanchwala','spring123','mkanchwala','Hindi'),
  (2,'mkanchwala','2015-05-22 23:20:00','mohamed@ewan.care',1,'2015-05-22 23:20:00','mkanchwala','spring123','ewan.gy','Arabic'),
  (3,'mkanchwala','2015-05-22 23:20:00','guest@ewan.care',1,'2015-05-22 23:20:00','mkanchwala','spring123','guest.gy','Hindi');
COMMIT;

#
# Data for the `user_role` table  (LIMIT 0,500)
#

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES 
  (1,1),
  (1,2),
  (2,1),
  (3,1);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;