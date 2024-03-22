package com.company;

public class Book implements Record
{
    private String bookId,title,authorName,PublisherName;
    private int quantity;

    public Book(String bookId, String title, String authorName, String publisherName, int quantity)
    {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        PublisherName = publisherName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String lineRepresentation()
    {
        return
                bookId +
                "," + title +
                "," + authorName +
                "," + PublisherName +
                "," + quantity
                ;
    }

    public String getSearchKey(){
        return bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
