package org.product.repository;

import org.springframework.stereotype.Repository;
import org.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}