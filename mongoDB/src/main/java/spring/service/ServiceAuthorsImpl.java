package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.doman.Authors;
import spring.repository.AuthorsRepository;

@Service
public class ServiceAuthorsImpl implements ServiceAuthors {
    @Autowired
    private AuthorsRepository authorsRepository;

    @Transactional
    @Override
    public Iterable<Authors> getAuthors(Sort sort) {
        Iterable<Authors> all = authorsRepository.findAll(sort);
        return all;
    }

    @Transactional
    @Override
    public Authors findByFirstName(String name) {
        return authorsRepository.findByFirstName("Хорстман");
    }
}
