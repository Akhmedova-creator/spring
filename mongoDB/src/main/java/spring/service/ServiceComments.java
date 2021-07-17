package spring.service;

import spring.doman.Comments;
import java.time.LocalDate;

public interface ServiceComments {
    Comments getCommentsByDate(LocalDate date);
}
