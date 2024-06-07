package pl.coderslab.Workshop_5.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.Workshop_5.Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class MockBookService implements BookService{
    private List<Book> list;

    public MockBookService() {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return list.stream().filter(el -> el.getId() == id).findFirst();
    }

    @Override
    public void add(Book book) {
        list.add(book);
    }

    @Override
    public void delete(Long id) {
        Optional<Book> deleteBook = list.stream().filter(el -> el.getId() == id).findFirst();
        deleteBook.ifPresent(book -> list.remove(book));
    }

    @Override
    public void update(Book book) {
        Optional<Book> updateBook = list.stream().filter(el -> el.getId() == book.getId()).findFirst();
        if(updateBook.isPresent()) {
            updateBook.get().setAuthor(book.getAuthor());
            updateBook.get().setIsbn(book.getIsbn());
            updateBook.get().setTitle(book.getTitle());
            updateBook.get().setAuthor(book.getAuthor());
            updateBook.get().setPublisher(book.getPublisher());
            updateBook.get().setGenre(book.getGenre());
        }
    }
}
