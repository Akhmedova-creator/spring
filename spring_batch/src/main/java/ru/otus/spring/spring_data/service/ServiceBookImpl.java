package ru.otus.spring.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.spring_data.domain.Authors;
import ru.otus.spring.spring_data.domain.Genre;
import ru.otus.spring.spring_data.domain.Books;
import ru.otus.spring.spring_data.repository.BooksRepository;
import ru.otus.spring.spring_data.repository.GenreRepository;

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
        return booksRepository.findByGenreAndAuthors(genre,
                authors);
    }

}
