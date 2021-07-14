package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import spring.doman.Books;
import spring.doman.Comments;

@Component
public class BookCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event ){
        Object source = event.getSource();
        if(source instanceof Books){
                if(((Books)source).getAuthors()!= null) {
                    mongoOperations.save(((Books)source).getAuthors());
                }

                if(((Books)source).getGenre()!= null)
                    mongoOperations.save(((Books)source).getGenre());

                if(!((Books)source).getComments().isEmpty()) {
                    for (Comments el: ((Books)source).getComments()) {
                        mongoOperations.save(el);
                    }
                }
        }
    }
}
