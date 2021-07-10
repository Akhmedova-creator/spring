package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.BooksDaoRepositoriesJPA;
import ru.otus.spring.domain.Books;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceBookImpl implements ServiceBook {

    @Autowired
    private BooksDaoRepositoriesJPA booksDaoRepositoriesJPA;

    @Transactional
    @Override
    public List<Books> getBooks() {
        return booksDaoRepositoriesJPA.findAll();
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
         booksDaoRepositoriesJPA.deleteById(id);
    }
}

