package events;

import dtos.CategoryRequestDTO;
import lombok.Getter;

public class CategoryCreatedEvent extends BaseEvent<Long>{
    @Getter
    private CategoryRequestDTO payload;

    public CategoryCreatedEvent(Long id, CategoryRequestDTO payload) {
        super(id);
        this.payload = payload;
    }
}
