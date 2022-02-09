package ru.otus.spring.mongock.changelog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Comment;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;

import java.time.LocalDate;

/**
 * Заполнение первоначальными данными документов в mongo
 */
@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "addBooks", author = "AkhmedovaFI")
    public void insertBooks(BookRepository bookRepository) {
        Book book = new Book("50 оттенков серого",
                new Genre("Роман"),
                new Author("Джеймс",
                        "Леонард"));

        Comment comment1 = new Comment("Комментарий 1",
                LocalDate.now(),
                book);
        Comment comment2 = new Comment("Комментарий 2",
                LocalDate.now(),
                book);

        bookRepository.save(book);
    }

    @ChangeSet(order = "002", id = "addAuthors", author = "AkhmedovaFI")
    public void insertAuthors(AuthorRepository authorRepository) {
        authorRepository.save(new Author("Ахмедова",
                "Фарзона"));

    }

    @ChangeSet(order = "003", id = "addGenre1", author = "AkhmedovaFI")
    public void insertGenre1(GenreRepository genreRepository) {
        genreRepository.save(new Genre("Наука"));

    }

    @ChangeSet(order = "004", id = "addGenre2", author = "AkhmedovaFI")
    public void insertGenre2(GenreRepository genreRepository) {
        genreRepository.save(new Genre("Фантастика"));

    }
}