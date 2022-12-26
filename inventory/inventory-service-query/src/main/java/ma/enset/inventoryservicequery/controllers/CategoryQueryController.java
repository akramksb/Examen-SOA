package ma.enset.inventoryservicequery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.inventoryservicequery.entities.Category;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.GetAllCategoriesQuery;

import java.util.List;

@RestController
@RequestMapping("/inventory/query/")
@AllArgsConstructor
@Slf4j
public class CategoryQueryController {
    QueryGateway queryGateway;
    @GetMapping("/allCategories")
    public List<Category> accountList(){
        List<Category> response = queryGateway.query(
                new GetAllCategoriesQuery(),
                ResponseTypes.multipleInstancesOf(Category.class)
        ).join();

        return response;
    }
}
