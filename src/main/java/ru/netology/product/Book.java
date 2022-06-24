package ru.netology.product;

public class Book extends Product {
    private String author;

    public Book(int id, String name, String author) {
        super.id = id;
        super.name = name;
        this.author = author;
    }
}
