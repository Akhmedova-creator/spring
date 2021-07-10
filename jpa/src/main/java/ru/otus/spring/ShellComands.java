package ru.otus.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.service.ServiceBook;

import javax.transaction.Transactional;

@ShellComponent
public class ShellComands {

    @Autowired
    private ServiceBook serviceBook;

    @ShellMethod(value = "command", key = {"getAll"})
    public void getAll() {
        System.out.println(serviceBook.getBooks());
    }

    @ShellMethod(value = "command", key = {"delete"})
    public void delete() {
       serviceBook.deleteBook(1l);
    }
}