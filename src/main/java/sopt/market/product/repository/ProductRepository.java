package sopt.market.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sopt.market.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<Product> getRandomProducts(int count);

    Optional<Product> findById(Long id);

    @Query(value = "SELECT * FROM products ORDER BY view DESC LIMIT 5", nativeQuery = true)
    List<Product> findTop5ByView();
}
