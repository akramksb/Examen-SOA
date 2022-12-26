package ma.enset.customerservicequery.repositories;

import ma.enset.customerservicequery.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
