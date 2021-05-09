package repository;


import dto.Product;

import java.sql.SQLException;
import java.util.List;

//DAO 단이라고도 하나봄
public interface ProductRepository {
    List<Product> getProducts();
    void save(Product product) throws SQLException;

    Product getProductById(int id);

    void update(Product product);

    void delete(int id);
}
