insert into genre ( `name`) values('Наука');
insert into genre ( `name`) values('Роман');

insert into author (FIRST_NAME,LAST_NAME) values('Хорстман','Кей');
insert into author (FIRST_NAME,LAST_NAME) values('Михаил','Лабковcкий');
insert into author (FIRST_NAME,LAST_NAME) values('Джеймс','Леонард');

insert into book (title,genreId,authorId) values ('Алгоритмы и структуры данных',1,1);
insert into book (title,genreId,authorId) values ('Джава.Основы',1,1);

insert into comment (COMMENT_DATA,COMMENT_NAME,BOOKID) values('2021-12-31','Книга была испавлена',1);
insert into comment (COMMENT_DATA,COMMENT_NAME,BOOKID) values ('2019-12-31','Книгу дали на доработку',1);

