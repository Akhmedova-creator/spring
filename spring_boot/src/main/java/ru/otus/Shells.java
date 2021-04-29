package ru.otus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.service.TestService;

@ShellComponent
public class Shells {

    @Autowired
    private TestService testService;

    @ShellMethod(value = "command", key = {"start"})
    public String startTest(@ShellOption(defaultValue = "тест начался") String name) {
        System.out.println(name);
        return String.format(testService.getTest().getResultAnswer());
    }
}
