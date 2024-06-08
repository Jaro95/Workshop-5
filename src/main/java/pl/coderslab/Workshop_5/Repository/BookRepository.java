package pl.coderslab.Workshop_5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Workshop_5.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
