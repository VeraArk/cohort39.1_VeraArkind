package practice;

import practice.interfaces.AuthorRepository;
import practice.interfaces.BookRepository;
import practice.interfaces.ReaderRepository;
import practice.repositories.AuthorRepositoryImpl;
import practice.repositories.BookRepositoryImpl;
import practice.repositories.ReaderRepositoryImpl;
import practice.services.AuthorService;
import practice.services.BookService;
import practice.services.ReaderService;

import java.util.Scanner;


// Слой представления
public class LibraryApplication {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReaderRepository readerRepository;

    private final AuthorService authorService;
    private final BookService bookService;
    private final ReaderService readerService;


    private final Scanner scanner;

    public LibraryApplication(BookRepository bookRepository, AuthorRepository authorRepository, ReaderRepository readerService, BookService bookService, ReaderService readerService1) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.readerRepository = readerService;
        this.bookService = bookRepository;
        this.readerService = new ReaderService(this.readerRepository);
        this.authorService = new AuthorService(this.authorRepository);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Добро пожаловать в систему управления библиотекой!");
            System.out.println("1. Показать список книг");
            System.out.println("2. Показать список авторов");
            System.out.println("3. Показать список читателей");
            System.out.println("4. Добавить новую книгу");
            System.out.println("5. Регистрация нового читателя");
            System.out.println("6. Добавить нового автора");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Вывести список всех книг или проверить наличие конкретной книги?");
                    System.out.println("1. Вывести список всех книг");
                    System.out.println("2. проверить наличие книг конкретного автора");

                    scanner.nextLine();
                    if (scanner.nextLine().equals("1")) {
                        System.out.println(bookService.getAllBooks());// !!!!!!!!!!!!
                    } else {
                        System.out.println("Введите имя и фамилию автора");
                        String authorName = scanner.nextLine();
                        System.out.println(bookService.findAllBooks(authorName));
                    }
                    break;
                case 2:
                    // Логика отображения списка авторов
                    System.out.println("Вывести всех авторов или искать по имени?");
                    System.out.println("1. Вывести всех авторов");
                    System.out.println("2. Искать по имени");

                    scanner.nextLine();
                    if (scanner.nextLine().equals("1")) {
                        System.out.println(authorService.getAllAuthors());
                    } else {
                        System.out.println("Введите имя автора");
                        String authorName = scanner.nextLine();
                        System.out.println(authorService.findAllAuthors(authorName));
                    }
                    break;
                case 3:
                    System.out.println(readerService.getAllReaders());
                    break;
                case 4:
                    bookService.addBook(scanner);
                    break;
                case 5:
                    readerService.addReader(scanner);
                    break;
                case 6:
                    authorService.addAuthor(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        AuthorRepository authorService = new AuthorRepositoryImpl();
        ReaderRepository readerService = new ReaderRepositoryImpl();

        LibraryApplication app = new LibraryApplication(bookRepository, authorService, readerService);
        app.run();
    }
}

