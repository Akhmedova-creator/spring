package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Genre;
import spring.repository.BooksRepository;
import spring.repository.GenreRepository;

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
