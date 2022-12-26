package ma.enset.inventoryservicequery.mappers;

import dtos.CategoryRequestDTO;
import ma.enset.inventoryservicequery.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category from(CategoryRequestDTO categoryRequestDTO);
    CategoryRequestDTO from(Category category);
}
