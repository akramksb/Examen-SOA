package ma.enset.customerservicequery.controlles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.customerservicequery.entities.Customer;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.GetAllCustomersQuery;

import java.util.List;

@RestController
@RequestMapping("/customers/query")
@AllArgsConstructor
@Slf4j
public class CustomerQueryController {
    QueryGateway queryGateway;
    @GetMapping("/allCustomers")
    public List<Customer> accountList(){
        List<Customer> response = queryGateway.query(
                new GetAllCustomersQuery(),
                ResponseTypes.multipleInstancesOf(Customer.class)
        ).join();

        return response;
    }

//    @GetMapping("/byId/{id}")
//    public Customer getCustomer(@PathVariable String id){
//        Customer response = queryGateway.query(
//                new GetCustomerByIdQuery(id),
//                ResponseTypes.instanceOf(Customer.class)
//        ).join();
//
//        return response;
//    }
}
