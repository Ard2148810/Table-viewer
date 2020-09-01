package pki.sqlTables.content.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public AuthorEntity addAuthor(AuthorEntity newAuthor) {
        return authorRepository.save(newAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public AuthorEntity updateAuthor(Long id, AuthorEntity updatedAuthor) {
        return authorRepository.findById(id)                            // Find old author
                .map(oldAuthor -> {                                     // Update properties
                    oldAuthor.setFirstName(updatedAuthor.getFirstName());
                    oldAuthor.setLastName(updatedAuthor.getLastName());
                    return authorRepository.save(oldAuthor);            // Save updated in DB
                })
                .orElseGet(() -> {                                      // If doesn't exist then save with expected id
                    updatedAuthor.setId(id);
                    return authorRepository.save(updatedAuthor);
                });
    }

}
