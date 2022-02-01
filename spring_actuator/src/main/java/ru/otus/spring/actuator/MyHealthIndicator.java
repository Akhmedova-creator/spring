package ru.otus.spring.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import ru.otus.spring.repository.BookRepository;

/**
 * Свой собственный healctCheck для проверки книг в репозитории
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Health health() {
        if (bookRepository.findAll().size()==0){
           return Health.down()
                   .status(Status.DOWN)
                   .withDetail("message","Книг не осталось!")
                   .build();

        }
        else
            return Health.up().withDetail("message", "Пока есть книги")
        .build();

    }
}
