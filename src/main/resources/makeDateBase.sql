create table `user` (
    `id`  bigint not null auto_increment ,
    `login_name`  varchar(255) not null ,
    `pass`  varchar(255) null ,
     `name`  varchar(255) null ,
     `sex`  int(11) null ,
     primary key (`id`)
);