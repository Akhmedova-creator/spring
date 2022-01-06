package ru.otus.spring.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.spring_data.domain.Comments;
import ru.otus.spring.spring_data.repository.CommentsRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceCommentsImpl implements ServiceComments {
    @Autowired
    private CommentsRepository commentsRepository;

    @Transactional
    @Override
    public List<Comments> getCommentsByDate(LocalDate date) {
        return commentsRepository.getNowDate(date);
    }
}
