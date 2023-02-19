package model;

public class Book {
    private String BookID, BookTitle, Author;
    private int YearPublished;

    public Book() {
        super();
    }

    public Book(String bookID, String bookTitle, String Author, int yearPublished) {
        this.BookID = bookID;
        this.BookTitle = bookTitle;
        this.Author = Author;
        this.YearPublished = yearPublished;
    }

    public String getBookID() {
        return this.BookID;
    }

    public void setBookID(String bookID) {
        this.BookID = bookID;
    }

    public String getBookTitle() {
        return this.BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.BookTitle = bookTitle;
    }

    public String getAuthor() {
        return this.Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public int getYearPublished() {
        return this.YearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.YearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "{" +
                " BookID='" + getBookID() + "'" +
                ", BookTitle='" + getBookTitle() + "'" +
                ", Author='" + getAuthor() + "'" +
                ", YearPublished='" + getYearPublished() + "'" +
                "}";
    }
    
    public boolean cmpID(String id) {
    	return this.BookID.equals(id);
    }
    
    public boolean cmpTitle(String t) {
    	return this.BookTitle.equals(t);
    }
    
    public boolean cmpAuthor(String a) {
    	return this.Author.equals(a);
    }
    
    public boolean cmpYear(int y) {
    	return this.YearPublished == y;
    }

}
