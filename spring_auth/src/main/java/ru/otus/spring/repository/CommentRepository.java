package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import ru.otus.spring.domain.Comment;

import java.time.LocalDate;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @PostFilter("hasPermission(filterObject, 'READ')")
    @Query("select c from comment c where c.commentData=:date")
    List<Comment> getNowDate(@Param("date") LocalDate date);
}
