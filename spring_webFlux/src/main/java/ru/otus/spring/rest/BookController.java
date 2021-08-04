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
        Genre genre=genreRepository.findById(idGenre).block();
        System.out.println(genre);
        return bookRepository.save(
                new Book(title,new Genre("ddd")
                        ,
                        new Author("sss","dddd")));


    }

}
