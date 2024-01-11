package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByProductName(String nameToSearch);
}
