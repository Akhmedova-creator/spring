package spring.service;

import org.springframework.data.domain.Sort;
import spring.doman.Authors;

public interface ServiceAuthors {
    Iterable<Authors> getAuthors(Sort sort);
    Authors findByFirstName(String name);
}
