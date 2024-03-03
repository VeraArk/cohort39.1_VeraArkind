package practice.services;

import practice.interfaces.AuthorRepository;
import practice.interfaces.BookRepository;
import practice.models.Author;
import practice.models.Book;
import practice.models.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Слой бизнес-логики
public class BookService {
    private BookRepository bookRepository;

    // метод показа всех книг в библиотеке.
    // что для этого надо?
    // - иметь доступ к репозитоию с книгами

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(String nameOfAuthor) {
        List<Book> bookList = new ArrayList<>();

        for (Book book : bookRepository.findAllBooks()) {
            if (book.getTitle().equals(nameOfAuthor)) {
                bookList.add(book);
            }
    }
        return bookList;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public void addBook(Scanner scanner) {
        //stub
        scanner.nextLine();
        System.out.println("Пожалуйста введите название книги:");
        String title = scanner.nextLine();
        System.out.println("Пожалуйста, введите имя автора:");
        String nameOfAuthor = scanner.nextLine();
        System.out.println("... и его год рождения автора: ");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        Author author1 = new Author(nameOfAuthor, yearOfBirth);

        /// нужна проверка условия: если такого автора нет в репозитории авторов, его туда надо добавить...Но
        // я запуталась в создании объектов для использования метода public List<Author> findAllAuthors(String name) в
        // классе AuthorService

        System.out.println("Введите жанр произведения:");
        String genre = scanner.nextLine();

        Book book = new Book(title, author1, Genre.valueOf(genre));
        if(bookRepository.findAllBooks().contains(book)){
            System.out.println("Такая книга уже есть в библиотеке");
            return;
        }
        bookRepository.addBook(book);
    }




}
