package practice.models;

// Модель
public class Book {
    private String title;
    private Author author;
    Enum getGenre;

    public Book(String title, Author author, Enum getGenre) {
        this.title = title;
        this.author = author;
        this.getGenre = getGenre;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Enum getGetGenre() {
        return getGenre;
    }
}
