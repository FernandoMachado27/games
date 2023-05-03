create table games(
	id bigint not null auto_increment,
    name varchar(100) not null,
    platform varchar(100) not null,
    stars varchar(5) not null,
    gender varchar(100) not null,
    
    primary key(id)
)