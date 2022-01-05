package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.repository.AuthorsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceAuthorsImpl implements ServiceAuthors {

    @Autowired
    private AuthorsRepository authorsRepository;

    @Transactional
    @Override
    public List<Authors> getAuthors(Sort sort) {
        return  authorsRepository.findAll(sort);
    }

    @Transactional
    @Override
    public Authors findByFirstName(String name) {
        return authorsRepository.findByFirstName("Хорстман");
    }
}
