package pki.sqlTables.content.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/api/authors")
    @CrossOrigin
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @MessageMapping("/authors/add")
    @SendTo("/topic/authors/add")
    public AuthorEntity addAuthor(AuthorEntity newAuthor) {
        return authorService.addAuthor(newAuthor);
    }

    @MessageMapping("/authors/delete/{id}")
    @SendTo("/topic/authors/delete/{id}")
    public Long deleteAuthor(@DestinationVariable Long id) {
        authorService.deleteAuthor(id);
        return id;
    }

    @MessageMapping("/authors/update/{id}")
    @SendTo("/topic/authors/update/{id}")
    public AuthorEntity updateAuthor(@DestinationVariable Long id, AuthorEntity updatedAuthor) {
        return authorService.updateAuthor(id, updatedAuthor);
    }

}
