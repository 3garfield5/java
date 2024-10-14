package lab3;

public class Book {
    private String name;
    private String author;
    private int countCopy;

    public Book(String name, String author, int countCopy) {
        this.name = name;
        this.author = author;
        this.countCopy = countCopy;
    }
    public Book() {
        this.name = "Названия нет";
        this.author = "Нет автора";
        this.countCopy = 0;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCountCopy() {
        return countCopy;
    }

}
