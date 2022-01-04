package ru.otus.spring.config;

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

/**
 * Класс -реалиация джобы. Миграция данных из SQL в NOSQL
 */
@Configuration
public class JobConfig {

    private static final int CHUNK_SIZE = 5;
    private final Logger logger = LoggerFactory.getLogger("Batch");

    private static final String IMPORT_USER_JOB_NAME = "importUserJob";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    /**
     * чтение данных из mongodb
     * @return данные из таблицы BooksMongo
     */
    @StepScope
    @Bean
    public MongoItemReader<BooksMongo> reader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<BooksMongo>().name("ItemReader")
                .template(mongoTemplate)
                .jsonQuery("{}")
                .targetType(BooksMongo.class).sorts(
                        new HashMap<>()).build();

    }

    /**
     * перевод книги из nosql(mongo) в sql
     * @param transfor классдля выполнения перевода
     * @return книга из хранилищи spring-data
     */
    @StepScope
    @Bean
    public ItemProcessor<BooksMongo, Books> processor(Transfor transfor) {
        return transfor::doBooks;
    }

    /**
     * класс работа для осуществления миграции
     * @param transformPersonsStep шаги чтение,перевод и запись данных
     * @return выполненую работу
     */
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


    /**
     * запись в репозиторий spring-data
     * @param dataSource для работы с sql
     * @return записанную сущгность
     */
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

    /**
     * объединение шагов
     * @param reader чтение даных из mongo
     * @param writer запись в реляционную бд
     * @param itemProcessor перевод сущности из mongo репозитория в data-репозиторий
     * @return выполненый шаг
     */
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

