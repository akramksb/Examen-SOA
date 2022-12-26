package dtos;

import enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String name;
    private double price;
    private int quantity;
    private ProductStatus status;
    private Long categoryId;
}
