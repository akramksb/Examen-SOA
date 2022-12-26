package ma.enset.inventoryservicecommand.controllers;

import commands.category.CreateCategoryCommand;
import dtos.CategoryRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/inventory/command/")
@AllArgsConstructor
@Slf4j
public class CategoryCommandController {
    CommandGateway commandGateway;

    @PostMapping("/categories/create")
    public CompletableFuture<String> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return commandGateway.send(new CreateCategoryCommand(
                null,
                categoryRequestDTO
        ));
    }
}
