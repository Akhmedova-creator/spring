package spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.doman.Comments;

import java.util.List;


public interface CommentsRepository extends MongoRepository<Comments,Long> {
    List<Comments> findAll();
    Comments findByCommentName(String name);

}
