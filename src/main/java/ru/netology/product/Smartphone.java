package ru.netology.product;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, String manufacturer) {
        super.id = id;
        super.name = name;
        this.manufacturer = manufacturer;
    }
}
