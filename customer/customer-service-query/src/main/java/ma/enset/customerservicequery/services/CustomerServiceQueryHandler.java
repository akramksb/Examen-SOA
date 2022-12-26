package ma.enset.customerservicequery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.customerservicequery.entities.Customer;
import ma.enset.customerservicequery.repositories.CustomerRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import queries.GetAllCustomersQuery;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CustomerServiceQueryHandler {
    private CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> on(GetAllCustomersQuery event){
        log.info("***********");
        log.info("GetAllCustomersQuery received");
        return customerRepository.findAll();
    }
}
