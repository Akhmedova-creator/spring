package ru.otus.spring.spring_data.service;

import ru.otus.spring.spring_data.domain.Comments;

import java.time.LocalDate;
import java.util.List;

public interface ServiceComments {
    List<Comments> getCommentsByDate(LocalDate date);
}
