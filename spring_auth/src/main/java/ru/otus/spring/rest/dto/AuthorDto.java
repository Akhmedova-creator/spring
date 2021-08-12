package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.domain.Author;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;
    private Long id;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getFirstName() + " " + author.getLastName(),
                author.getId());
    }
}

