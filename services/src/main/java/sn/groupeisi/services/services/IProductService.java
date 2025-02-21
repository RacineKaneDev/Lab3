package sn.groupeisi.services.services;

import sn.groupeisi.services.dto.ProductDTORequest;
import sn.groupeisi.services.dto.ProductDTOResponse;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTOResponse> getAllProducts();
    Optional<ProductDTOResponse> getProductById(Long id);
    ProductDTOResponse addProduct(ProductDTORequest productDTORequest);
    void deleteProduct(Long id);
}
