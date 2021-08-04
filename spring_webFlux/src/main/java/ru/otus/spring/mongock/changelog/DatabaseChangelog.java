package ru.otus.spring.mongock.changelog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Comment;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.CommentRepository;
import ru.otus.spring.repository.GenreRepository;

import java.time.LocalDate;
import java.util.Arrays;


@ChangeLog
@Log
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "addBooks", author = "AkhmedovaFI")
    public void insertBooks(BookRepository bookRepository, CommentRepository commentRepository) {

        Book book=new Book("50 оттенков серого",
                new Genre("Роман"),
                new Author("Джеймс",
                        "Леонард"));
       bookRepository.save(book).subscribe();

        commentRepository.saveAll(Arrays.asList(new Comment("Комментарий 1",
               LocalDate.now(), book),
                new Comment("Комментарий 2", LocalDate.now(),
                book))).subscribe();


    }

    @ChangeSet(order = "002", id = "addAuthors", author = "AkhmedovaFI")
    public void insertAuthors(AuthorRepository authorRepository) {
        authorRepository.save(new Author("Ахмедова", "Фарзона")).subscribe();

    }

    @ChangeSet(order = "003", id = "addGenre1", author = "AkhmedovaFI")
    public void insertGenre1(GenreRepository genreRepository) {
        genreRepository.save(new Genre("Наука")).subscribe();

    }

    @ChangeSet(order = "004", id = "addGenre2", author = "AkhmedovaFI")
    public void insertGenre2(GenreRepository genreRepository) {
        genreRepository.save(new Genre("Фантастика")).subscribe();

    }
}