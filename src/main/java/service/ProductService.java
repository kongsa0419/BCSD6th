package service;


import dto.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    void save(Product product);

    Product getProductById(int id);

    void update(Product product);

    void delete(int id);
}
