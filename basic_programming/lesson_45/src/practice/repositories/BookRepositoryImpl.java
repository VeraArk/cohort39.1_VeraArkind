package practice.repositories;

import practice.interfaces.BookRepository;
import practice.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private List<Book> books;

    public BookRepositoryImpl() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Book has already exist");
        } else {
            books.add(book);
            System.out.println("Book has been added");
        }
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }
}
