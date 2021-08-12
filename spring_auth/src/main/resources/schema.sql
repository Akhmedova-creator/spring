DROP TABLE IF EXISTS GENRE;
CREATE TABLE GENRE
(
  Id BIGINT  PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(255)
);

DROP TABLE IF EXISTS AUTHOR;
CREATE TABLE AUTHOR(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  FIRST_NAME VARCHAR(255),
  LAST_NAME VARCHAR(255)
);

DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK
(
  Id BIGINT  PRIMARY KEY AUTO_INCREMENT,
  TITLE VARCHAR(255),
  GENREID BIGINT,
  AUTHORID BIGINT ,
  FOREIGN KEY (GENREID)  REFERENCES GENRE (Id),
  FOREIGN KEY (AUTHORID)  REFERENCES AUTHOR (Id)
);

DROP TABLE IF EXISTS COMMENT;
CREATE TABLE COMMENT(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  COMMENT_DATA DATE,
  COMMENT_NAME VARCHAR(255),
  BOOKID BIGINT,
  FOREIGN KEY (BOOKID)  REFERENCES BOOK (Id)
);


create table IF NOT EXISTS system_message (id integer not null, content varchar(255), primary key (id));

CREATE TABLE IF NOT EXISTS acl_sid (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  principal tinyint(1) NOT NULL,
  sid varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_1 (sid,principal)
);

CREATE TABLE IF NOT EXISTS acl_class (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  class varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_2 (class)
);

CREATE TABLE IF NOT EXISTS acl_entry (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  acl_object_identity bigint(20) NOT NULL,
  ace_order int(11) NOT NULL,
  sid bigint(20) NOT NULL,
  mask int(11) NOT NULL,
  granting tinyint(1) NOT NULL,
  audit_success tinyint(1) NOT NULL,
  audit_failure tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_4 (acl_object_identity,ace_order)
);

CREATE TABLE IF NOT EXISTS acl_object_identity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  object_id_class bigint(20) NOT NULL,
  object_id_identity bigint(20) NOT NULL,
  parent_object bigint(20) DEFAULT NULL,
  owner_sid bigint(20) DEFAULT NULL,
  entries_inheriting tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_uk_3 (object_id_class,object_id_identity)
);

ALTER TABLE acl_entry
ADD FOREIGN KEY (acl_object_identity) REFERENCES acl_object_identity(id);

ALTER TABLE acl_entry
ADD FOREIGN KEY (sid) REFERENCES acl_sid(id);

--
-- Constraints for table acl_object_identity
--
ALTER TABLE acl_object_identity
ADD FOREIGN KEY (parent_object) REFERENCES acl_object_identity (id);

ALTER TABLE acl_object_identity
ADD FOREIGN KEY (object_id_class) REFERENCES acl_class (id);

ALTER TABLE acl_object_identity
ADD FOREIGN KEY (owner_sid) REFERENCES acl_sid (id);

