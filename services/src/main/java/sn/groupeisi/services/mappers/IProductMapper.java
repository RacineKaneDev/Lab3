package sn.groupeisi.services.mappers;

import org.mapstruct.Mapper;
import sn.groupeisi.services.dto.ProductDTORequest;
import sn.groupeisi.services.dto.ProductDTOResponse;
import sn.groupeisi.services.models.Product;

@Mapper
public interface IProductMapper {
    ProductDTORequest productToProductDTORequest(Product product);
    ProductDTOResponse productToProductDTOResponse(Product product);
    Product productDTORequestToProduct(ProductDTORequest productDtoRequest);
    Product productDTOResponseToProduct(ProductDTOResponse productDtoResponse);
}
