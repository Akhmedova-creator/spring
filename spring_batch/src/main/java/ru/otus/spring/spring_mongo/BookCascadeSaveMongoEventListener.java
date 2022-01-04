package ru.otus.spring.spring_mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;

@Component
public class BookCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        if (source instanceof BooksMongo) {
            if (((BooksMongo) source).getAuthorsMongo() != null) {
                mongoOperations.save(((BooksMongo) source).getAuthorsMongo());
            }

            if (((BooksMongo) source).getGenreMongo() != null)
                mongoOperations.save(((BooksMongo) source).getGenreMongo());

        }
    }
}
