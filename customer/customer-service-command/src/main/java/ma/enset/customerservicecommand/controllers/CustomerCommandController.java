package ma.enset.customerservicecommand.controllers;

import commands.customer.CreateCustomerCommand;
import dtos.CreateCustomerDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/customers/command/")
@AllArgsConstructor
public class CustomerCommandController {
    CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){
        return commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                createCustomerDTO.getName(),
                createCustomerDTO.getAddress(),
                createCustomerDTO.getEmail(),
                createCustomerDTO.getTel()
        ));
    }
}
