package ru.otus.spring;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * главный класс для запуска приложения
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class,
                args);
        Console.main(args);
    }
}
