package spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.doman.Comments;

import java.time.LocalDate;

public interface CommentsRepository extends MongoRepository<Comments,Long> {
    Comments findByCommentName(String name);
    Comments findByCommentData(LocalDate date);

}
