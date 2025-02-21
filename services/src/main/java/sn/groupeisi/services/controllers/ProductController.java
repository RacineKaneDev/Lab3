package sn.groupeisi.services.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.services.dto.ProductDTORequest;
import sn.groupeisi.services.dto.ProductDTOResponse;
import sn.groupeisi.services.services.IProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin (value = "http://localhost:4200")
@RequestMapping(name = "product-controller", path = "/api/v1/products")
public class ProductController {
    private final IProductService productService;
    // ✅ 1️⃣ Récupérer tous les produits
    @GetMapping
    public ResponseEntity<List<ProductDTOResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    // ✅ 2️⃣ Récupérer un produit par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTOResponse> getProductById(@PathVariable Long id) {
        Optional<ProductDTOResponse> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // ✅ 3️⃣ Ajouter un nouveau produit
    @PostMapping
    public ResponseEntity<ProductDTOResponse> addProduct(@RequestBody ProductDTORequest productDTORequest) {
        ProductDTOResponse createdProduct = productService.addProduct(productDTORequest);
        return ResponseEntity.ok(createdProduct);
    }
    // ✅ 4️⃣ Supprimer un produit par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
