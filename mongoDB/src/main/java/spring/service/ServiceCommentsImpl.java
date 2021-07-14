package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.doman.Comments;
import spring.repository.CommentsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceCommentsImpl implements ServiceComments {
    @Autowired
    private CommentsRepository commentsRepository;

    @Transactional
    @Override
    public List<Comments> getCommentsByDate(LocalDate date) {
      //  return commentsRepository.getNowDate(date);
        return  null;
    }
}
