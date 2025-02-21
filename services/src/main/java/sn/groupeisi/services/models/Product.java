package sn.groupeisi.services.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private Long id;
    private String name;
    private double price;
}
