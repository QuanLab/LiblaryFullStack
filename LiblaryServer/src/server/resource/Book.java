package server.resource;

public class Book {

    private String idBook;
    private String bookName;
    private String author;
    private String publisher;
    private int number;

    public Book(String idBook, String bookName, String author, String publisher) {
        this.idBook = idBook;
        this.author = author;
        this.publisher = publisher;
        this.bookName = bookName;
    }

    public String getMaSach() {
        return this.idBook;
    }

    public void setMaSach(String maSach) {
        this.idBook = maSach;
    }

    public String getTenSach() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumber() {
        return number;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
