package ru.otus.spring.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.rest.dto.BookDto;
@Data
@RestController
public class BookController {

    private  final AuthorRepository authorRepository;

    private final GenreRepository genreRepository;

   private final BookRepository bookRepository;


    @GetMapping("/api/books")
    public Flux<BookDto> listBook() {
        return bookRepository.findAll().map(BookDto::toDto);
    }

    @GetMapping("/delete/{id}")
    public Mono<String> deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id).subscribe();
        return Mono.just("успешно удалена книга");
    }

    @PostMapping("/saveBooks")
    public Mono<Book> save(@RequestParam String title,@RequestParam  String idGenre,@RequestParam String idAuthor) {

        Genre genre = new Genre();

        genreRepository.findById(idGenre)
                .subscribe(value ->{genre.setId(value.getId()); genre.setName(value.getName());});

        Author author = new Author();
        authorRepository.findById(idAuthor).subscribe(value->{author.setFirstName(value.getFirstName());
            author.setLastName(value.getLastName());
            author.setId(value.getId());});

        return bookRepository.save(
                new Book(title,genre, author));


    }

}
