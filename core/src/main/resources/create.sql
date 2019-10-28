create database `task_db`
    character set 'utf8mb4'
    collate 'utf8mb4_general_ci';

create table `task_db`.`task`
(
    `ID`        integer(10) unsigned not null auto_increment unique,
    `Summary`   varchar(200)         not null,
    `StartDate` date                 not null,
    `EndDate`   date,
    `Assignee`  varchar(200),
    primary key (`id`)
) engine = InnoDB
  default charset = utf8mb4;