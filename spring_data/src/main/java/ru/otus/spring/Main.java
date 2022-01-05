package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.repository.CommentsRepository;
import ru.otus.spring.service.ServiceBook;
import ru.otus.spring.service.ServiceComments;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);
        ServiceBook serviceComments = context.getBean(ServiceBook.class);
    }
}
