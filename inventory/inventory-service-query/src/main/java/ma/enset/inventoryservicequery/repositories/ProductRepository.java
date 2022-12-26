package ma.enset.inventoryservicequery.repositories;

import ma.enset.inventoryservicequery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
