package ru.otus.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
@Table(name = "books")
@NamedEntityGraph(name = "comments-entity-graph",
        attributeNodes = {@NamedAttributeNode("comments")})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne(targetEntity = Genre.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "genreid")
    private Genre genre;

    @ManyToOne(targetEntity = Authors.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "authorsid")
    private Authors authors;

    @OneToMany(targetEntity = Comments.class, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "bookid")
    private List<Comments> comments;

    public Books(String title, Genre genre, Authors authors, List<Comments> comments) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comments=" + comments +
                '}';
    }
}

