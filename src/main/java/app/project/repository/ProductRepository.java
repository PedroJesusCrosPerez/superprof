package app.proyecto.repository;

import app.proyecto.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // TODO add year column
    List<Product> findAllByYear(Integer year);

}
