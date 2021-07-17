package spring.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import spring.doman.Authors;

public interface AuthorsRepository extends MongoRepository<Authors, Long> {
    Authors findByFirstName(String name);
}
