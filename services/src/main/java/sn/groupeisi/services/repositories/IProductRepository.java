package sn.groupeisi.services.repositories;

import sn.groupeisi.services.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    void addProduct(Product product);
    void deleteProduct(Long id);
}
