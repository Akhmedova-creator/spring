package ru.otus.spring.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repository.AuthorsRepository;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.rest.dto.BookDto;
import ru.otus.spring.service.ServiceBook;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class BookController {
    public ServiceBook serviceBook;
    public AuthorsRepository authorsRepository;
    public GenreRepository genreRepository;

    @GetMapping("/api/books")
    public List<BookDto> listBook() {
        return serviceBook.getAllBooks().stream().map(BookDto::toDto)
                .collect(Collectors.toList());

    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book book = serviceBook.findBookById(id);
        serviceBook.deleteBook(book);
        return "успешно удалена книга";
    }

    @PostMapping("/saveBooks")
    public Book save(String title, Long idGenre, Long idAuthor) {
        Genre genre = genreRepository.getById(idGenre);
        Author author = authorsRepository.getById(idAuthor);
        Book save = new Book();
        save.setTitle(title);
        save.setGenre(genre);
        save.setAuthor(author);
        return serviceBook.add(save);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlNotFind(NotFoundException handlNotFind) {
        return ResponseEntity.badRequest().body("Not find entity");
    }
}
