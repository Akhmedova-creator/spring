insert into genre ( `name`) values('Наука');
insert into genre ( `name`) values('Роман');

insert into author (FIRST_NAME,LAST_NAME) values('Хорстман','Кей');
insert into author (FIRST_NAME,LAST_NAME) values('Джеймс','Леонард');
insert into author (FIRST_NAME,LAST_NAME) values('Михаил','Лабковcкий');

insert into book (title,genreId,authorId) values ('Джава.Spring-фреймворк',1,1);
insert into book (title,genreId,authorId) values ('50 оттенков серого',2,2);

insert into comment (COMMENT_DATA,COMMENT_NAME,BOOKID) values('2021-12-31','Книга была испавлена',1);
insert into comment (COMMENT_DATA,COMMENT_NAME,BOOKID) values ('2019-12-31','Книгу дали на доработку',1);


INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 1, 'admin'),
(2, 1, 'user'),
(3, 0, 'ROLE_EDITOR');

INSERT INTO acl_class (id, class) VALUES
(1, 'ru.otus.spring.domain.Author'),
(2, 'ru.otus.spring.domain.Book'),
(3, 'ru.otus.spring.domain.Genre');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 1, NULL, 3, 0),
(2, 1, 2, NULL, 3, 0),
(3, 1, 3, NULL, 3, 0),
(4, 2, 1, NULL, 3, 0),
(5, 2, 2, NULL, 3, 0),
(6, 3, 1, NULL, 3, 0),
(7, 3, 2, NULL, 3, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask,
                       granting, audit_success, audit_failure) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 2, 2, 1, 1, 1, 1, 1),
(3, 3, 3, 1, 1, 1, 1, 1),
(4, 1, 4, 2, 1, 1, 1, 1),
(5, 2, 5, 2, 1, 1, 1, 1),
(6, 3, 6, 2, 1, 1, 1, 1),
(7, 4, 1, 1, 8, 1, 1, 1),
(8, 5, 2, 1, 8, 1, 1, 1),
(9, 4, 3, 1, 2, 1, 1, 1),
(10,5, 4, 1, 2, 1, 1, 1),
(11,4, 5, 1, 1, 1, 1, 1),
(12,5, 6, 1, 1, 1, 1, 1),
(13,4, 7, 2, 1, 1, 1, 1),
(14,5, 8, 2, 1, 1, 1, 1),
(15,6, 1, 1, 1, 1, 1, 1),
(16,7, 2, 1, 1, 1, 1, 1),
(17,6, 3, 2, 1, 1, 1, 1),
(18,7, 4, 2, 1, 1, 1, 1);

