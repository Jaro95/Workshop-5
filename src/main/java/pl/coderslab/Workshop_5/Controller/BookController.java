package pl.coderslab.Workshop_5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Workshop_5.Model.Book;
import pl.coderslab.Workshop_5.Repository.BookRepository;
import pl.coderslab.Workshop_5.Service.BookService;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping()
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }
    @GetMapping("/test")
    public String helloTest(Model model) {
        model.addAttribute("message","DZIAlA?");
        return "test";
    }

    @GetMapping("/helloBook")
    public Book helloBook() {
        Book book = new Book("9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public String addBooks(@RequestParam long id, @RequestParam String isbn, @RequestParam String title,@RequestParam String author
            ,@RequestParam String publisher,@RequestParam String genre) {
        bookRepository.save(new Book(isbn,title,author,publisher,genre));
        return "Added book";
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable long id) {

        return bookRepository.findById(id);
    }

    @PutMapping("/books")
    public String updateBook(@RequestParam long id, @RequestParam String isbn, @RequestParam String title,@RequestParam String author
            ,@RequestParam String publisher,@RequestParam String genre) {
        bookRepository.save(new Book(id,isbn,title,author,publisher,genre));
        return "Updated: " + title;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
        return "Deleted: " + id;
    }

}