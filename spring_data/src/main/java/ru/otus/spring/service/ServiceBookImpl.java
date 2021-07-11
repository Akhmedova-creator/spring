package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repository.BooksRepository;
import ru.otus.spring.domain.Books;
import ru.otus.spring.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceBookImpl implements ServiceBook {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    @Override
    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    @Transactional
    @Override
    public List<Books> getBooksByGenreAndAuthors(Genre genre, Authors authors) {
        return booksRepository.findByGenreAndAuthors(genre,authors);
    }

}
