package bookStore;

import bookStore.exception.BookNotFoundException;
import bookStore.models.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/* With @Autowired property, the system will implement
   by itself a new instance for interface BookRepository  */
@RestController
@Api(description = "Restful webservice")
public class EBSRestController {

    @Autowired
    private BookRepository bookRepository;

    @ApiOperation(value = "retrive all books", response = List.class)
    @GetMapping(value = "/rest/books",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @ApiOperation(value = "retrive a specific book by id", response = Book.class)
    @GetMapping(value = "/rest/books/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Optional<Book> getBook(@ApiParam("Id of the book")@PathVariable("id") long id){
        Optional<Book> bookFound = bookRepository.findById(id);

        if(!bookFound.isPresent())
            throw new BookNotFoundException("id=" + id);

        return bookFound;
    }

    @ApiOperation(value = "delete a specific book by id")
    @DeleteMapping(value = "/rest/books/{id}")
    public void delete(@ApiParam("Id of the book") @PathVariable("id") long id){
        bookRepository.deleteById(id);
    }

    /* To use this method, if the body is written in JSon,
    *  you should specify it in Header request like Content-Type = application/json.*/
    @ApiOperation(value = "Add a new book to book store")
    @PostMapping(value = "/rest/books",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> newBook(@ApiParam("New book to add")@RequestBody Book newBook){
        Book newOne = bookRepository.save(newBook);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newOne.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Update the info about a book in the book store")
    @PutMapping(value = "/rest/books/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> update(@ApiParam("New info to update")@RequestBody Book book,
                    @ApiParam("id for the book to update") @PathVariable("id") long id){

        Optional<Book> bookOptional = bookRepository.findById(id);

        if(!bookOptional.isPresent())
            throw new BookNotFoundException("id=" + id);

        book.setId(id);
        bookRepository.save(book);

        return ResponseEntity.noContent().build();
    }
}
