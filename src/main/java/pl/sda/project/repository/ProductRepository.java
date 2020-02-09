package pl.sda.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.project.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
