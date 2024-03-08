package practice.services;
import practice.interfaces.ReaderRepository;
import practice.models.Reader;

import java.util.List;
import java.util.Scanner;


// Слой бизнес-логики
public class ReaderService {

    private ReaderRepository repository;

    public ReaderService(ReaderRepository repository) {
        this.repository = repository;
    }

    public List<Reader> getAllReaders() { return repository.findAllReaders();
    }

    public void addReader(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите в качестве логина адрес электронной почты: ");
        String login = scanner.nextLine();

        String regex = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}”)";
        if (!login.matches(regex)){
            System.out.println("Вы ввели некорректный адрес электронной почты");
            return;
        }

        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        Reader reader = new Reader(login, password);
        repository.registerReader(reader);
    }

}
