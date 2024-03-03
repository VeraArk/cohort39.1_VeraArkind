package practice.interfaces;

import practice.models.Book;

import java.util.List;

// Слой доступа к данным (Data Access Layer)
public interface BookRepository {
    void addBook(Book book);
    public List<Book> findAllBooks();
}

