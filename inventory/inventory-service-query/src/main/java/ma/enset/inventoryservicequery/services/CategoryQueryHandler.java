package ma.enset.inventoryservicequery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.inventoryservicequery.entities.Category;
import ma.enset.inventoryservicequery.repositories.CategoryRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import queries.GetAllCategoriesQuery;
import queries.GetAllCustomersQuery;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CategoryQueryHandler {
    private CategoryRepository categoryRepository;
    @QueryHandler
    public List<Category> on(GetAllCategoriesQuery event){
        log.info("***********");
        log.info("GetAllCategoriesQuery received");
        return categoryRepository.findAll();
    }
}
