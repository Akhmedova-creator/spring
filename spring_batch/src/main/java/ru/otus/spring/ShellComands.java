package ru.otus.spring;

import com.github.cloudyrock.spring.v5.EnableMongock;
import lombok.Data;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.spring_data.repository.AuthorsRepository;
import ru.otus.spring.spring_data.repository.BooksRepository;
import ru.otus.spring.spring_data.repository.GenreRepository;

@ShellComponent
@ComponentScan
@EnableMongock
@Data
public class ShellComands {

    private final Job importUserJob;

    private final JobLauncher jobLauncher;
    private final JobOperator jobOperator;
    private final JobExplorer jobExplorer;


    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorsRepository authorsRepository;


    @ShellMethod(value = "command", key = {"getAllGenre"})
    public void getAllGenre() {
        System.out.println(genreRepository.findAll());
    }

    @ShellMethod(value = "command", key = {"getAllAuthors"})
    public void getAllAuthors() {
        System.out.println(authorsRepository.findAll());
    }

    @ShellMethod(value = "command", key = {"getAll"})
    public void getAll() {
        System.out.println(booksRepository.findAll());
    }

    @ShellMethod(value = "startMigrationJobWithJobLauncher", key = "sm-jl")
    public void startMigrationJobWithJobLauncher() throws Exception {
        JobExecution execution = jobLauncher.run(importUserJob,
                new JobParametersBuilder()
                        .toJobParameters());
        System.out.println(execution);
    }

}