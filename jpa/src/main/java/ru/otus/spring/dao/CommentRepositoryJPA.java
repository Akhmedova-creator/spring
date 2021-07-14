package ru.otus.spring.dao;

import ru.otus.spring.domain.Comments;

import java.util.List;

public interface CommentRepositoryJPA {

    List<Comments> findAllCommentsByBook(String booksName);
}
