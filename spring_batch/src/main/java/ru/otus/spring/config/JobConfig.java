package ru.otus.spring.config;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.lang.NonNull;
import ru.otus.spring.Transfor;
import ru.otus.spring.spring_data.domain.Books;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class JobConfig {

    private static final int CHUNK_SIZE = 5;
    private final Logger logger = LoggerFactory.getLogger("Batch");

    public static final String IMPORT_USER_JOB_NAME = "importUserJob";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @StepScope
    @Bean
    public MongoItemReader<BooksMongo> reader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<BooksMongo>().name("ItemReader")
                .template(mongoTemplate)
                .jsonQuery("{}")
                .targetType(BooksMongo.class).sorts(
                        new HashMap<>()).build();

    }

    @StepScope
    @Bean
    public ItemProcessor<BooksMongo, Books> processor(Transfor transfor) {
        return transfor::doBooks;
    }

    @Bean
    public Job importUserJob(Step transformPersonsStep) {
        return jobBuilderFactory.get(IMPORT_USER_JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .flow(transformPersonsStep)
                .end()
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(@NonNull JobExecution jobExecution) {
                        logger.info("Начало job");
                    }

                    @Override
                    public void afterJob(@NonNull JobExecution jobExecution) {
                        logger.info("Конец job");
                    }
                })
                .build();
    }


    @StepScope
    @Bean
    public JdbcBatchItemWriter<Books> writer(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Books>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO genre (name) VALUES (:genre.name); " +
                        "INSERT INTO authors (first_name, last_name) VALUES (:authors.firstName, :authors.lastName); " +
                        "INSERT INTO books (title, genreid, authorsid) VALUES (:title, (SELECT max(id) FROM genre), " +
                        "(SELECT max(id) FROM authors))")
                .dataSource(dataSource)
                .build();

    }

    @Bean
    public Step transformPersonsStep(ItemReader<BooksMongo> reader,
                                     ItemWriter<Books> writer,
                                     ItemProcessor<BooksMongo, Books> itemProcessor) {
        TaskletStep transformPersonsStep = stepBuilderFactory.get("transformPersonsStep")
                .<BooksMongo, Books>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .build();
        return transformPersonsStep;
    }
}

