package ru.otus.spring.rest;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.service.ServiceAuthor;
import ru.otus.spring.service.ServiceBook;
import ru.otus.spring.service.ServiceGenre;

import java.util.List;

@Data
@Controller
public class BookController {
    private final ServiceBook serviceBook;

    private final ServiceAuthor serviceAuthor;

    private final ServiceGenre serviceGenre;


    private void initAttributes(Model model) {
        model.addAttribute("author",
                serviceAuthor.getAuthors());
        model.addAttribute("genres",
                serviceGenre.getGenres());
        model.addAttribute("newBook");
        model.addAttribute("newAuthor");
        model.addAttribute("newGenre");

    }

    @GetMapping("/")
    public String listBook(Model model) {
        List<Book> book = serviceBook.getBooks();
        model.addAttribute("book",
                book);
        return "list";

    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable String id, Model model) {
        Book book = serviceBook.findByIdBook(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book",
                book);
        return "edit";
    }

    @PostMapping("/edit")
    public String editBook(Book book, Model model) {
        Book save = serviceBook.findByIdBook(book.getId()).orElseThrow(NotFoundException::new);
        save.setTitle(book.getTitle());
        model.addAttribute("book",
                serviceBook.saveBook(save));
        return "edit";
    }

    @GetMapping("/save")
    public String savePage(Model model) {
        initAttributes(model);
        return "save";
    }

    @GetMapping("/delete")
    public String deleteBook(Model model, @RequestParam String id) {
        Book book = serviceBook.findByIdBook(id).orElseThrow(NotFoundException::new);
        serviceBook.deleteBook(book);
        model.addAttribute("book",
                serviceBook.getBooks());
        return "list";
    }


    @PostMapping("/save")
    public String saveBook(Model model, @ModelAttribute(value = "newBook")
            String title, @ModelAttribute(value = "newAuthor")
                                   String idAuthor, @ModelAttribute(value = "newGenre") String idGenre) {

        Genre genre = serviceGenre.findByIdGenre(idGenre).orElseThrow(NotFoundException::new);
        Author author = serviceAuthor.findByIdAuthor(idAuthor).orElseThrow(NotFoundException::new);
        Book save = new Book();
        save.setTitle(title);
        save.setGenre(genre);
        save.setAuthor(author);
        serviceBook.saveBook(save);

        initAttributes(model);

        return "save";
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlNotFind(NotFoundException handlNotFind) {
        return ResponseEntity.badRequest().body("Not find entity");
    }
}
