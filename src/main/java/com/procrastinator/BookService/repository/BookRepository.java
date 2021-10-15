package com.procrastinator.BookService.repository;

import com.procrastinator.BookService.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/* GENERIC TYPEs
* 1. Book==> which table we are going to store
* 2. Integer==> primary key of the book table/class */

@Transactional  //If all APIs are Transactional this will also work.
public interface BookRepository extends JpaRepository<Book,Integer> {
/*
    JpaRepository interface is present in Spring data jpa dependency
* It contains all relevant methods which we need for querying on DB. */

    /* Spring-data-JPA gives us an abstraction to define any query over a function
    * By using @Query Annotation.
    * So whenever the Custom function is invoked the function return the output of the query
    * written in @Query Annotation. */

    //@Query("select * from Book b where b.authorName= :?1")
    // ?1 --> refers to first parameter/argument of a function.
    // ?2 --> refers to second argument of function if function has 2 parameters.

        //In the below query we have written authorName(Java class attribute) and not author_name(Column in SQL table)
    //because Hibernate converts authorName(of Java class) to author_name(of SQL table)
    //@Entity Annotation when given to a Java class it maps Java class to SQL table. (Done by Hibernate)

        //@Query("select * from books_table where author_name=?1,nativeQuery=true") // Parameter Index
        //@Query("select * from books_table where author_name=:author_name //Colon operator/Parameter Name

        @Query(value = "select * from books_table b where b.author_name= :author_name",nativeQuery = true) //native SQL Format
         List<Book> findBooksByAuthorName(String author_name);

        @Query("select b from Book b where b.cost< ?1") //parameter index
        List<Book> findBooksLessThanByCost(int cost);

        @Modifying      //used for classifying that this query changes data in DB
        @Transactional  //Making the query atomic i.e. either execute completely or not at all. No Partial Execution.
        @Query("update Book b set b.cost=?2 where b.id=?1")
        void updateBook(int bookId,int newCost);

        //Find all the books written by a particular author.
        List<Book> findByAuthorName(String authorName);
        //This function has name convention designated by Hibernate so no need to use @Query Annotation.

        //Spring-data-JPA has Property Reference
        //That means getByPropertyName OR findByPropertyName this functions will work without @Query Annotation.
        //i.e. PropertyName is any variable of the class for whom the repository is created.
        //Book class --> BookRepository



         //There are 2 ways to write SQL queries in @Query Annotation.
    /* 1. JPQL- Java Persistence Query Language
           In JPQL we consider our Java class and not the corresponding MySQL table
           in our Case Book class in JAVA has books_table in MySQL.

           But in JPQL we consider java class for they query.
           Java class is mapped to SQL table.
           When we write JPQL queries we are concerned about Java class and not about SQL table
           SO when we write query we write in the format which is understood by Java Program.

    *  2. Native SQL ==> Our std SQL queries
        Here we refer the table present in SQL DB and not the Java class name.

        @Query Annotation has one parameter called nativeQuery=false;
        by default it is false as we are using JPQL
        but if we want to use Native SQL then it should be -- nativeQuery=true;

        */
}
