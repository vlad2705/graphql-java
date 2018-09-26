package eu.rudenvla.graphqljava.repository;

import eu.rudenvla.graphqljava.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {}
