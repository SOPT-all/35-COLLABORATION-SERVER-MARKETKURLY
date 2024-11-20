package sopt.market.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sopt.market.product.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products ORDER BY RAND() LIMIT ?1, nativeQuery = True")
    List<Product> getRandomProducts(int count);
}