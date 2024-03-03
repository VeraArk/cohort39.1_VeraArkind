package practice.services;

import practice.interfaces.AuthorRepository;
import practice.models.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Слой бизнес-логики
public class AuthorService {
    private AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> findAllAuthors(String name) {
        List<Author> authorList = new ArrayList<>();

        for (Author author : repository.findAllAuthors()) {
            if (author.getName().contains(name)) {
                authorList.add(author);
            }
        }

        return authorList;
    }


    public List<Author> getAllAuthors() {
        return repository.findAllAuthors();
    }

    public void addAuthor(Scanner scanner) {
        //stub
        scanner.nextLine();
        System.out.println("Пожалуйста введите полное имя автора:");
        String authorName = scanner.nextLine();
        System.out.println("Пожалуйста год рождения автора:");
        int yearOfBirth = scanner.nextInt();
        if (yearOfBirth < 0 || yearOfBirth > 2020) {
            // год отрицательным быть не может, даже если он до нашей эры, поэтому добавила такое условие
            System.err.println("Вы ввели некорректные данные");
        }

        Author author = new Author(authorName, yearOfBirth);
        repository.addAuthor(author);
    }
}
