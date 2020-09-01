package pki.sqlTables.content.books;

import lombok.Data;
import pki.sqlTables.content.authors.AuthorEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String isbn;

    private String title;

    private Integer author;

    private Integer pages;
}
