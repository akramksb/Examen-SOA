package ma.enset.inventoryservicequery.services;

import dtos.CategoryRequestDTO;
import dtos.ProductRequestDTO;
import events.CategoryCreatedEvent;
import events.product.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.inventoryservicequery.entities.Category;
import ma.enset.inventoryservicequery.entities.Product;
import ma.enset.inventoryservicequery.repositories.CategoryRepository;
import ma.enset.inventoryservicequery.repositories.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CategoryEventHandler {
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(CategoryCreatedEvent event){
        log.info("***********");
        log.info("ProductCreatedEvent received");
        CategoryRequestDTO payload = event.getPayload();

        Category category = Category.builder()
                .name(payload.getName())
                .description(payload.getDescription())
                .build();

        categoryRepository.save(category);
    }
}
