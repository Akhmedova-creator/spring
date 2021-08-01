package ru.otus.spring.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.spring.rest.BookController;


@Controller
public class BookPageController {
    @Autowired
    private BookController bookController;

    @GetMapping("/list")
    public String pageList(Model model) {
        return "list";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute(value = "newBook")
                                   String title, @ModelAttribute(value = "newAuthor")
                                   String idAuthor, @ModelAttribute(value = "newGenre") String idGenre) {
        bookController.saveBook(title,
                idGenre,
                idAuthor);
        return "save";

    }

    @GetMapping("/save")
    public String save(Model model) {
        return "save";
    }
}
