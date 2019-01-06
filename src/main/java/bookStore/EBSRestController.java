package bookStore;

import bookStore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EBSRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/rest/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping(value = "/rest/books/{id}")
    public Optional<Book> getBook(@PathVariable("id") long id){
        return bookRepository.findById(id);
    }

    @DeleteMapping(value = "/rest/books/{id}")
    public void delete(@PathVariable("id") long id){
        bookRepository.deleteById(id);
    }

    @PostMapping(value = "/rest/books")
    public ResponseEntity<Object> newBook(@RequestBody Book book){
        Book newOne = bookRepository.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newOne.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/rest/books/{id}")
    public ResponseEntity<Object> update(@RequestBody Book book, @PathVariable("id") long id){

        Optional<Book> bookOptional = bookRepository.findById(id);

        if(!bookOptional.isPresent())
            return ResponseEntity.notFound().build();

        book.setId(id);
        bookRepository.save(book);

        return ResponseEntity.noContent().build();
    }
}
