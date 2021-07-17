package spring.service;


import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Genre;

import java.util.List;

public interface ServiceBook {
    List<Books> getBooks();

    List<Books> getBooksByGenreAndAuthors(Genre genre, Authors authors);
}
