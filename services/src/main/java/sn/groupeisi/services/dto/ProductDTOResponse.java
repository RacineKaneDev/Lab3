package sn.groupeisi.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponse {
    private Long id;
    private String name;
    private double price;
}
