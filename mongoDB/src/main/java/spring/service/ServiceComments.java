package spring.service;


import spring.doman.Comments;

import java.time.LocalDate;
import java.util.List;

public interface ServiceComments {
    List<Comments> getCommentsByDate(LocalDate date);
}
