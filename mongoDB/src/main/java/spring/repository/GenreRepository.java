package spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.doman.Genre;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre,Integer> {
    Genre findByName(String name);
    List<Genre> findAll();
}
