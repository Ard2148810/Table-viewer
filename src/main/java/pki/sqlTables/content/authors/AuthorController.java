package pki.sqlTables.content.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/api/authors")
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
