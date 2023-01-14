CREATE SCHEMA `shool` ;

CREATE TABLE `shool`.`tutorials`(
    `id`          char(10)  NOT NULL auto_increment,
    `title`        varchar(50),
     `description`        varchar(800),
      `published`        boolean,
      primary key(id)
);

CREATE TABLE `shool`.`comments`
(
    `id`         char(10)    NOT NULL auto_increment,
	`content`     text NOT NULL,
    `tutorial_id`         char(10)     NOT NULL,
    primary key(id),
    FOREIGN KEY (tutorial_id) References tutorials (id)
);


