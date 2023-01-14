CREATE SCHEMA `shool` ;

CREATE TABLE `shool`.`tutorials`(
    `id`          char(10)  NOT NULL primary key,
    `title`        varchar(50),
     `description`        varchar(800),
      `published`        boolean
);

CREATE TABLE `shool`.`comments`
(
    `id`         char(10)    NOT NULL primary key,
	`content`     text NOT NULL,
    `tutorial_id`         char(10)     NOT NULL,
    FOREIGN KEY (tutorial_id) References tutorials (id)
);


