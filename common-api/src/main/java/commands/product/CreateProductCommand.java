package commands.product;

import commands.BaseCommand;
import dtos.ProductRequestDTO;
import lombok.Getter;

public class CreateProductCommand extends BaseCommand<Long> {
    @Getter
    private ProductRequestDTO payload;

    public CreateProductCommand(Long id, ProductRequestDTO payload) {
        super(id);
        this.payload = payload;
    }
}
