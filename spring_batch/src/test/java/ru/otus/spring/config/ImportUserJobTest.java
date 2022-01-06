package ru.otus.spring.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTypeExcludeFilter;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.spring.spring_data.domain.Authors;
import ru.otus.spring.spring_data.domain.Books;
import ru.otus.spring.spring_data.domain.Genre;
import ru.otus.spring.spring_data.repository.BooksRepository;
import ru.otus.spring.spring_data.service.ServiceBook;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.otus.spring.config.JobConfig.IMPORT_USER_JOB_NAME;


@SpringBatchTest
@TypeExcludeFilters({DataMongoTypeExcludeFilter.class})
@AutoConfigureDataMongo
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class ImportUserJobTest {

    private JobLauncher jobLauncher;
    private Job importUserJob;

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private ServiceBook serviceBook;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @BeforeEach
    void clearMetaData() {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Test
    void testJob() throws Exception {


        Books book1 = new Books(1L,
                "Алгоритмы и структуры данных",
                new Genre(1L,
                        "Наука"),
                new Authors(1L,
                        "Хорстман",
                        "Кей"));

        Books book2 = new Books(2L,
                "Джава.Основы",
                new Genre(1L,
                        "Наука"),
                new Authors(1L,
                        "Хорстман",
                        "Кей"));

        Books book3 = new Books(3L,
                "Джава.Spring-фреймворк",
                new Genre(1L,
                        "Наука"),
                new Authors(1L,
                        "Хорстман",
                        "Кей"));

        Books book4 = new Books(4L,
                "50 оттенков серого",
                new Genre(2L,
                        "Роман"),
                new Authors(2L,
                        "Михаил",
                        "Лабковcкий"));

        Books book5 = new Books(5L,
                "50 оттенков серого",
                new Genre(3L,
                        "Роман"),
                new Authors(4L,
                        "Джеймс",
                        "Леонард"));

        Books book6 = new Books(6L,
                "50 серого",
                new Genre(4L,
                        "Роман"),
                new Authors(5L,
                        "Джеймс",
                        "Леонард"));

        List<Books> expectedList = Arrays.asList(book1,
                book2,
                book3,
                book4,
                book5,
                book6);

        Job job = jobLauncherTestUtils.getJob();
        assertThat(job).isNotNull()
                .extracting(Job::getName)
                .isEqualTo(IMPORT_USER_JOB_NAME);

        JobParameters parameters = new JobParametersBuilder()
                .toJobParameters();
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(parameters);

        assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo("COMPLETED");
        assertEquals(serviceBook.getBooks(),
                expectedList);
    }
}