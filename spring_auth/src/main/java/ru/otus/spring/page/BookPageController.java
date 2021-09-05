package ru.otus.spring.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookPageController {

    @GetMapping("/list")
    public String pageList() {
        return "list";
    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }
}
