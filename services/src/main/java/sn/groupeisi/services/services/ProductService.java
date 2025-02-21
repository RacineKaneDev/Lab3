package sn.groupeisi.services.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.groupeisi.services.dto.ProductDTORequest;
import sn.groupeisi.services.dto.ProductDTOResponse;
import sn.groupeisi.services.mappers.IProductMapper;
import sn.groupeisi.services.models.Product;
import sn.groupeisi.services.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final IProductMapper productMapper;

    @Override
    public List<ProductDTOResponse> getAllProducts() {
        return productRepository.getAllProducts().stream()
                .map(productMapper::productToProductDTOResponse)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<ProductDTOResponse> getProductById(Long id) {
        return productRepository.getProductById(id)
                .map(productMapper::productToProductDTOResponse);
    }
    @Override
    public ProductDTOResponse addProduct(ProductDTORequest productDTORequest) {
        Product product = productMapper.productDTORequestToProduct(productDTORequest);
        productRepository.addProduct(product);
        return productMapper.productToProductDTOResponse(product);
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }
}
