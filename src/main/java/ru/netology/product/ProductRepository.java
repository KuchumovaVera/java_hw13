package ru.netology.product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product newProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;

        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        if (products.length != 0) {
            if (findById(id) == null) {
                throw new NotFoundException("Element with id: " + id + " not found");
            }

            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
            }
            products = tmp;
        }
    }

    public Product findById(int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }
}
