package pl.coderslab.Workshop_5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Workshop_5.Model.Book;
import pl.coderslab.Workshop_5.Service.BookService;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping()
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/start")
    public String start(){
        return "base";
    }

    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/books")
    public String addBooks(@RequestParam long id, @RequestParam String isbn, @RequestParam String title,@RequestParam String author
            ,@RequestParam String publisher,@RequestParam String genre) {
        bookService.add(new Book(id,isbn,title,author,publisher,genre));
        return "Added book";
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable long id) {
        return bookService.get(id);
    }

    @PutMapping("/books")
    public String updateBook(@RequestParam long id, @RequestParam String isbn, @RequestParam String title,@RequestParam String author
            ,@RequestParam String publisher,@RequestParam String genre) {
        bookService.update(new Book(id,isbn,title,author,publisher,genre));
        return "Updated: " + title;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "Deleted: " + id;
    }

}