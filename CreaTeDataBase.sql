drop schema IF exists `shool`;

CREATE SCHEMA `shool` ;

drop table IF exists `shool`.`tutorials`;
drop table IF exists `shool`.`comments`;

CREATE TABLE `shool`.`tutorials`(
    `id`          char(10)  NOT NULL ,
    `title`        varchar(50),
     `description`        varchar(800),
      `published`        boolean,
      primary key(id)
);

CREATE TABLE `shool`.`comments`
(
    `id`         char(10)    NOT NULL ,
	`content`     text NOT NULL,
    `tutorial_id`         char(10)     NOT NULL,
    primary key(id),
    FOREIGN KEY (tutorial_id) References tutorials (id)
);

INSERT INTO `shool`.`tutorials` (`id`, `title`, `description`, `published`) VALUES ('1', 'English', 'English language training', true);
INSERT INTO `shool`.`tutorials` (`id`, `title`, `description`, `published`) VALUES ('2', 'Mathematics', 'Mathematics teaching', true);
INSERT INTO `shool`.`tutorials` (`id`, `title`, `description`, `published`) VALUES ('3', 'Algebra', 'Algebra training', true);
INSERT INTO `shool`.`tutorials` (`id`, `title`, `description`, `published`) VALUES ('4', 'Geometry', 'Geometry teaching', true);
INSERT INTO `shool`.`tutorials` (`id`, `title`, `description`, `published`) VALUES ('5', 'History', 'Teaching the history of the world', true);
INSERT INTO `shool`.`tutorials` (`id`, `title`, `description`, `published`) VALUES ('6', 'Literature', 'Peace Literature Teaching', true);

INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('1', 'There were 10 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('2', 'There were 11 students in the tutorial', '2');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('3', 'There were 15 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('4', 'There were 10 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('5', 'There were 9 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('6', 'There were 12 students in the tutorial', '3');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('7', 'There were 13 students in the tutorial', '5');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('8', 'There were 10 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('9', 'There were 10 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('10', 'There were 10 students in the tutorial', '1');
INSERT INTO `shool`.`comments` (`id`, `content`, `tutorial_id`) VALUES ('11', 'There were 10 students in the tutorial', '1');