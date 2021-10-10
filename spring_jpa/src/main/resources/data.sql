insert into genre ( `name`) values('Наука');
insert into genre ( `name`) values('Роман');

insert into authors (FIRST_NAME,LAST_NAME) values('Хорстман','Кей');
insert into authors (FIRST_NAME,LAST_NAME) values('Джеймс','Леонард');
insert into authors (FIRST_NAME,LAST_NAME) values('Михаил','Лабковкий');

insert into books (title,genreId,authorsId) values ('Алгоритмы и структуры данных',1,1);
insert into books (title,genreId,authorsId) values ('Джава.Основы',1,1);
insert into books (title,genreId,authorsId) values ('Джава.Spring-фреймворк',1,1);
insert into books (title,genreId,authorsId) values ('50 оттенков серого',2,2);

insert into comments (COMMENT_DATA,COMMENT_NAME,BOOKID) values('2021-12-31','Книга была испавлена',1);
insert into comments (COMMENT_DATA,COMMENT_NAME,BOOKID) values ('2019-12-31','Книгу дали на доработку',1);



