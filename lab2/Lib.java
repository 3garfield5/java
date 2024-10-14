package lab2;

import java.util.List;

public class Lib extends Institution {
    private List<String> books;

    public Lib(String name, String address, List<String> books) {
        super(name, address);
        this.books=books;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books=books;
    }

    @Override
    public void describe() {
        System.out.println("Библиотека '"+ getName() + "' находится по адресу: '" + getAddress() + "'. Книги: " + String.join(", ", books));
    }

    @Override
    public String toString() {
        return "Library{" +
                "books="+ books +
                "}" + super.toString();

    }
}
