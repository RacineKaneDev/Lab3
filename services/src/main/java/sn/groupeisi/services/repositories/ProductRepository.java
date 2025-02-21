package sn.groupeisi.services.repositories;

import lombok.AllArgsConstructor;
import sn.groupeisi.services.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepository implements IProductRepository {
    private final List<Product> products = new ArrayList<>();
    private Long idCounter = 1L; // Pour générer des IDs uniques
    public ProductRepository() {
        // Ajout de quelques produits fictifs
        products.add(new Product(idCounter++, "Laptop", 1500.00));
        products.add(new Product(idCounter++, "Smartphone", 800.00));
        products.add(new Product(idCounter++, "Bluetooth Headphones", 200.00));
        products.add(new Product(idCounter++, "Tablet", 500.00));
    }
    @Override
    public List<Product> getAllProducts() {
        return products;
    }
    @Override
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
    @Override
    public void addProduct(Product product) {
        product = new Product(idCounter++, product.getName(), product.getPrice());
        products.add(product);
    }
    @Override
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
