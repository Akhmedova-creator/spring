package spring.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Comments;
import spring.doman.Genre;

import java.util.List;

public interface BooksRepository extends MongoRepository<Books,Long> {
    List<Books> findByGenreAndAuthors(Genre genre, Authors authors);
    List<Books> findByComments(Comments comments);
}
