package events.product;

import dtos.ProductRequestDTO;
import enums.ProductStatus;
import events.BaseEvent;
import lombok.Getter;

public class ProductCreatedEvent extends BaseEvent<Long> {
    @Getter
    private ProductRequestDTO payload;

    public ProductCreatedEvent(Long id, ProductRequestDTO payload) {
        super(id);
        this.payload = payload;
    }
}
