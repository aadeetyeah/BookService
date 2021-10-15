package com.procrastinator.BookService.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}


/**
 * This is the difference between GenerationType.IDENTITY and  GenerationType.AUTO
 * IDENTITY gives a DB level auto-increment i.e.
 * whether we insert directly via mysql cmd console or via our Java program(via Hibernate)
 * in both ways we don't have to mention Id as it is auto-increment.
 *
 * WHEREAS when GenerationType.AUTO here ID is only incremented by Hibernate(via JAVA program)
 * using hibernate_sequence table
 * and if we manually try to insert via mysql cmd console we have to manually select unique id.
 * Also this causes conflict if we again try to insert same ID via Hibernate.
 * Check below queries
 * id integer not null ==> AUTO in JAVA Code
 * id integer not null auto_increment ==> IDENTITY in JAVA Code.
 *
 * Hibernate: create table books_table (id integer not null, author_name varchar(255), book_added_on datetime(6), cost integer not null, name varchar(255), primary key (id)) engine=InnoDB
 * Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
 * Hibernate: insert into hibernate_sequence values ( 1 )
 * Hibernate: create table user (id integer not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
 */