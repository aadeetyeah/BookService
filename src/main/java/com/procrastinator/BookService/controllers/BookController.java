package com.procrastinator.BookService.controllers;

import com.procrastinator.BookService.models.Book;
import com.procrastinator.BookService.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    /* Autowiring means giving dependency injection.
    * Providing required object at runtime. */

    @PostMapping("/book")
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @GetMapping("/bookById/{book_id}")
    public Book getBookById(@PathVariable("book_id") int bookId){
        return bookService.getBook(bookId);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("/updateBook")
    public void updateBookCostById(@RequestParam("id") int id,@RequestParam("cost") int newCost){
        bookService.updateBook(id,newCost);
    }

    /*Multiple path variable */
    @DeleteMapping("/deleteBook/{bId}/author/{authorId")
    public void deleteBookById(@PathVariable("bId") int id,@PathVariable("authorId") String author ){
        bookService.deleteBook(id);
    }

    @GetMapping("/bookByAuthorName")
    public List<Book> getBookByAuthorName(@RequestParam("author")String authorName){
        return bookService.findBooksByAuthorName(authorName);
    }

    @GetMapping("/bookByCost")
    public List<Book> getBooksByCost(@RequestParam("cost")int cost){
        //return all books where cost<100
        return bookService.findBooksLessThanByCost(cost);
    }

    //without @Query Annotation
    @GetMapping("/test")
    public List<Book> getBooksByAuthor(@RequestParam("name")String authorName){
        return bookService.findBookByAuthorName(authorName);
    }
}
