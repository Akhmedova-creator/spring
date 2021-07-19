package ru.otus.spring.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;


@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;


    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    private void initAttributes(Model model) {
        model.addAttribute("author",
                authorRepository.findAll());
        model.addAttribute("genres",
                genreRepository.findAll());
        model.addAttribute("newBook");
        model.addAttribute("newAuthor");
        model.addAttribute("newGenre");

    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> book = bookRepository.findAll();
        model.addAttribute("book",
                book);
        return "list";

    }

    @GetMapping("/edit")
    public String editPage(@RequestParam String id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Book book, Model model) {
        Book save = bookRepository.findById(book.getId()).orElseThrow(NotFoundException::new);
        save.setTitle(book.getTitle());
        model.addAttribute("book", bookRepository.save(save));
        return "edit";
    }

    @GetMapping("/save")
    public String savePage(Model model) {
        initAttributes(model);
        return "save";
    }

    @GetMapping("/delete")
    public String deleteBook(Model model, @RequestParam String id) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        bookRepository.delete(book);
        model.addAttribute("book", bookRepository.findAll());
        return "list";
    }


    @PostMapping("/save")
    public String saveBook(Model model, @ModelAttribute(value = "newBook")
            String title, @ModelAttribute(value = "newAuthor")
                                   String idAuthor, @ModelAttribute(value = "newGenre") String idGenre) {

       Genre genre = genreRepository.findById(idGenre).orElseThrow(NotFoundException::new);
        Author author = authorRepository.findById(idAuthor).orElseThrow(NotFoundException::new);
        Book save = new Book();
        save.setTitle(title);
        save.setGenre(genre);
        save.setAuthor(author);
        bookRepository.save(save);

        initAttributes(model);

        return "save";
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlNotFind(NotFoundException handlNotFind){
        return ResponseEntity.badRequest().body("Not find entity");
    }
}
