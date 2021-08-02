package ru.otus.spring.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.spring.rest.BookController;


@Controller
public class BookPageController {
    @Autowired
    private BookController bookController;

    @GetMapping("/list")
    public String pageList(Model model) {
        return "list";
    }

    @GetMapping("/save")
    public String save(Model model) {
        return "save";
    }
}
