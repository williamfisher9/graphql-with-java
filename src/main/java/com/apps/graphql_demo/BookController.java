package com.apps.graphql_demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
class BookController {

    @QueryMapping
    public List<Book> books() {
        return Book.books;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getBookById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getAuthorById(book.authorId());
    }

}
