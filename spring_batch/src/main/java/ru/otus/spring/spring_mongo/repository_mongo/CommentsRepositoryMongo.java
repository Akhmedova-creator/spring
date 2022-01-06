package ru.otus.spring.spring_mongo.repository_mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.spring_mongo.doman_mongo.CommentsMongo;

import java.time.LocalDate;

public interface CommentsRepositoryMongo extends MongoRepository<CommentsMongo, Long> {
    CommentsMongo findByCommentName(String name);

    CommentsMongo findByCommentData(LocalDate date);

}
