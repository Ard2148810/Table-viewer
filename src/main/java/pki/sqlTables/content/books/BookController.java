package pki.sqlTables.content.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/api/books")
    @CrossOrigin
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @MessageMapping("/books/add")
    @SendTo("/topic/books/add")
    public BookEntity addBook(BookEntity newBook) {
        try {
            return bookService.addBook(newBook);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @MessageMapping("/books/delete/{id}")
    @SendTo("/topic/books/delete/{id}")
    public Long deleteBook(@DestinationVariable Long id) {
        bookService.deleteBook(id);
        return id;
    }

    @MessageMapping("/books/update/{id}")
    @SendTo("/topic/books/update/{id}")
    public BookEntity updateBook(@DestinationVariable Long id, BookEntity updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }
}
