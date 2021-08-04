package ru.otus.spring.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookPageController {

    @GetMapping("/list")
    public String pageList(Model model) {
        return "list";
    }

    @GetMapping("/save")
    public String save(Model model) {
        return "save";
    }
}
