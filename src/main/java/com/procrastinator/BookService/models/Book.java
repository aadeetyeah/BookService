package com.procrastinator.BookService.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="books_table")
public class Book {

    @Id //This annotation makes a variable primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //ByDefault it is AUTO
    private int id;

    /* When GenerationType is AUTO then Hibernate will keep incrementing the id and saving the book
    *
    * But if GenerationType is not AUTO then the DB is responsible for creating ID
    *
    * AUTO is for Hibernate
    *
    * and TABLE,SEQUENCE,IDENTITY is for DB */

    private String name;
    private String authorName;
    private int cost;

    @CreationTimestamp //This is not a proper way of Auto-filling the date in DB.
    private Date bookAddedOn;
    //Instead use auto-fill the Date with DB methods and not via Hibernate/code level
    //Cuz DB will physically be present only at one location.
    //While multiple servers can be present at multiple locations.

}
