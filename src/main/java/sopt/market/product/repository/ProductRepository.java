package sopt.market.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.market.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
