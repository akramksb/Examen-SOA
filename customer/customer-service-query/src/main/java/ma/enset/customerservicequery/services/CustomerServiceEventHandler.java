package ma.enset.customerservicequery.services;

import events.CustomerCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.customerservicequery.entities.Customer;
import ma.enset.customerservicequery.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CustomerServiceEventHandler {
    private CustomerRepository customerRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("***********");
        log.info("CustomerCreatedEvent received");
        Customer customer = Customer.builder()
                .id(event.getId())
                .name(event.getName())
                .address(event.getAddress())
                .email(event.getEmail())
                .tel(event.getTel())
                .build();
        customerRepository.save(customer);
    }
}
