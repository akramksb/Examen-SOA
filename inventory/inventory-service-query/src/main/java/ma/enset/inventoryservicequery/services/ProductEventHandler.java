package ma.enset.inventoryservicequery.services;

import dtos.ProductRequestDTO;
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
public class ProductEventHandler {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        log.info("***********");
        log.info("ProductCreatedEvent received");
        ProductRequestDTO payload = event.getPayload();

        Category category = categoryRepository.findById(payload.getCategoryId()).get();

        Product product = Product.builder()
                .name(payload.getName())
                .price(payload.getPrice())
                .quantity(payload.getQuantity())
                .status(payload.getStatus())
                .category(category)
                .build();

        productRepository.save(product);
    }
}
