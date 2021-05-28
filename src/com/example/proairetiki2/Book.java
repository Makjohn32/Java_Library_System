package com.example.proairetiki2;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private int pages;
    private short year_published;
    private float price;

    //constructor
    public Book(String title,String author, String ISBN, String publisher,int pages, short year_published,float price){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.pages = pages;
        this.year_published = year_published;
        this.price = price;
    }
    public Book(){};

    //setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setYear_published(short year_delivered) {
        this.year_published = year_delivered;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //getters

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    public short getYear_published() {
        return year_published;
    }

    public float getPrice() {
        return price;
    }

    public  String toString(){
        return("Title:"+title+"\nAuthor:"+author+"\nISBN:"+ISBN+"\nPublisher:"+publisher+"\nPages:"+pages+"\nYear Published"+year_published+"\nPrice:"+price);
    }
}
