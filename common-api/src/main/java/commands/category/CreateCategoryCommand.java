package commands.category;

import commands.BaseCommand;
import dtos.CategoryRequestDTO;
import lombok.Getter;

public class CreateCategoryCommand extends BaseCommand<Long> {
    @Getter
    private CategoryRequestDTO payload;

    public CreateCategoryCommand(Long id, CategoryRequestDTO payload) {
        super(id);
        this.payload = payload;
    }
}
