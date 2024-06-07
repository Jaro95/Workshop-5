package pl.coderslab.Workshop_5.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String genre;
}
