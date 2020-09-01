package pki.sqlTables.content.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        List<BookEntity> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public BookEntity addBook(BookEntity newBook) {
        return bookRepository.save(newBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity updateBook(Long id, BookEntity updatedBook) {
        return bookRepository.findById(id)                           // Find old book
                .map(oldBook -> {                                    // Update properties
                    oldBook.setIsbn(updatedBook.getIsbn());
                    oldBook.setTitle(updatedBook.getTitle());
                    oldBook.setAuthor(updatedBook.getAuthor());
                    oldBook.setPages(updatedBook.getPages());
                    return bookRepository.save(oldBook);             // Save updated in DB
                })
                .orElseGet(() -> {                                   // If doesn't exist then save with expected id
                    updatedBook.setId(id);
                    return bookRepository.save(updatedBook);
                });
    }

}
