package service;


import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired //객체 생성하는 코드 없애줌. 객체가 없으면 생성해주니, 생성됐다고 보는것임.
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> list = productRepository.getProducts();
        return list;
    }

    @Override
    public void save(Product product) throws SQLException {
        productRepository.save(product);

    }

    @Override
    public Product getProductById(int id) {
        Product pd = productRepository.getProductById(id);
        return null;
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}
