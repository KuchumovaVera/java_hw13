package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {


    Book book1 = new Book(123, "Tom Soer", "M. Twen");
    Book book2 = new Book(234, "Maugly", "R. Kipling");
    Book book3 = new Book(345, "Revisor", "N. Gogol'");
    Smartphone smartphone1 = new Smartphone(456, "Honor8x", "China");
    Smartphone smartphone2 = new Smartphone(567, "iPhone11", "USA");
    Smartphone smartphone3 = new Smartphone(678, "Honor12x", "China");

    @Test
    void shouldManagerAddProduct() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerSearchBy() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldManagerSearchByEmpty() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();

        Product[] actual = manager.searchBy("AAA");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryRemoteById() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(567);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRepositoryRemoteByNullId() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.removeById(890);
        });
    }

    @Test
    void shouldRepositoryDeleteByIdIfArrayEmpty() {
        ProductManager manager = new ProductManager();
        manager.removeById(123);

        Product[] actual = manager.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
