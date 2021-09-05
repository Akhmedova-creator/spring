package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.domain.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;

    private String title;

    private String genre;

    private String author;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(),
                book.getTitle(),
                book.getGenre().getName(),
                book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
    }
}
