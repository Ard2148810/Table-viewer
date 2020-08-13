package pki.sqlTables.content.books;

import org.springframework.beans.factory.annotation.Autowired;
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
}
