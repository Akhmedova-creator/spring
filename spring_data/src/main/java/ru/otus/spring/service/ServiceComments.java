package ru.otus.spring.service;

import ru.otus.spring.domain.Comments;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface ServiceComments {
    List<Comments> getCommentsByDate(LocalDate date);

    @Transactional
    List<Comments> getComments();
}
