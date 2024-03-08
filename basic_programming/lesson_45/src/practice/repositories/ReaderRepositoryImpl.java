package practice.repositories;

import practice.interfaces.ReaderRepository;
import practice.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {

    private List<Reader> readers;

    public ReaderRepositoryImpl() {
        this.readers = new ArrayList<>();
    }

    @Override
    public void registerReader(Reader reader) {
        if (readers.contains(reader)) {
            System.out.println("Reader has already exist");
        } else {
            readers.add(reader);
            System.out.println("Reader has been already registered");
        }
    }

    @Override
    public List<Reader> findAllReaders() {
        return readers;
    }
}
