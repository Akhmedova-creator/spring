package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.domain.Genre;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private String name;
    private Long id;

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getName(),
                genre.getId());
    }

}
