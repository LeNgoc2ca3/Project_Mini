CREATE DATABASE Assignment_JAVA4;
USE Assignment_JAVA4;

create table Account
(
	id bigint auto_increment NOT NULL,
    username varchar(50) ,
    password varchar(50) ,
    role int ,
    constraint Account_PK primary key(id)
);

create table Product
(
	id bigint auto_increment NOT NULL,
    product_name nvarchar(100) ,
    price decimal(20,3) ,
    quantity int,
    created_user nvarchar(50),
    create_date datetime,
    description nvarchar(200),
    deleted bit default 0,
    last_modified_user varchar(50),
    last_modified_date datetime,
    shape varchar(20),
    taste bit default 0,
    constraint Product_PK primary key(id)
);

insert into Account
(username,password,role)
values('ngockk', '12345678', 1),
		('Duongcu', '87654321', 0),
        ('Danhvat', '88888888', 0);

insert into Product
(product_name,price,quantity,created_user,create_date,description,deleted,last_modified_user,last_modified_date,shape,taste)
values("Bánh bông lan",12000, 1, "Ngọc", current_date(),"Trống",0,"Ngọc",current_date(),"Tròn",0)