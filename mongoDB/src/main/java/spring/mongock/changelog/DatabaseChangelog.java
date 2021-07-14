package spring.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Comments;
import spring.doman.Genre;
import spring.repository.BooksRepository;

import java.time.LocalDate;
import java.util.ArrayList;

@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "addBooks", author = "AkhmedovaFI")
      public void insertBooks(BooksRepository booksRepository) {
        ArrayList <Comments> comments =new ArrayList<>();
        Comments comments1=new Comments("1","Комментарий 1",LocalDate.now());
        Comments comments2= new Comments("2","Комментарий 2",LocalDate.now());
        comments.add(comments1);
        comments.add(comments2);

        booksRepository.save(new Books("50 оттенков серого",
                new Genre("1","Роман"),
                new Authors("1","Джеймс","Леонард"),
                comments));
    }
}