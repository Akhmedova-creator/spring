package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.otus.spring.domain.Comments;

import java.time.LocalDate;
import java.util.List;

public interface CommentsRepository extends CrudRepository<Comments,Long> {
    @Query("select c from comments c where c.commentData=:date")
    List<Comments> getNowDate(@Param("date") LocalDate date );
}
