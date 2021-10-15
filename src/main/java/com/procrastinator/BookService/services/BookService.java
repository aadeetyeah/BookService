package com.procrastinator.BookService.services;

import com.procrastinator.BookService.models.Book;
import com.procrastinator.BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(int id){
        return bookRepository.findById(id).orElse(null);
    }



    public void deleteBook(int id){
        bookRepository.deleteById( id);
    }

    /*How to implement Custom query using Hibernate ?
    * e.g. find book where cost>100 --> This is custom requirement.
    * Therefore we need to write custom function */

    /* In order to complete the below custom functions
    * we need to create our own functions in BookRepository. */

    public void updateBook(int id,int newCost){
        bookRepository.updateBook(id,newCost);
    }

    public List<Book> findBooksByAuthorName(String authorName){
        return bookRepository.findBooksByAuthorName(authorName);
    }

    public List<Book> findBooksLessThanByCost(int cost){
        return bookRepository.findBooksLessThanByCost(cost);
    }

    public List<Book> findBookByAuthorName(String author){
        return bookRepository.findByAuthorName(author);
    }
}
