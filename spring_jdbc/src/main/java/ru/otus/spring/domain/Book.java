package ru.otus.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
/**
 * сущность,которая соотвествует таблице  books
 */
public class Book {
    private final String title;
    private final Genre genre;
    private final Authors authors;

    public Book(String title, Genre genre, Authors authors) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                genre.equals(book.genre) &&
                authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title,
                genre,
                authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", authors=" + authors +
                '}';
    }
}


