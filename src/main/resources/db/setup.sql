create database blog_db;

create user 'blogger'@'localhost' identified by 'myblog123';
grant all privileges on blog_db.* to 'blogger'@'localhost';
flush privileges