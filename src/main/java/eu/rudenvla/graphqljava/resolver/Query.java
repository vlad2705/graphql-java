package eu.rudenvla.graphqljava.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import eu.rudenvla.graphqljava.model.Product;
import eu.rudenvla.graphqljava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Queries to get data.
 */
@Service
public class Query implements GraphQLQueryResolver {
  private final ProductRepository productRepository;
  
  @Autowired
  public Query(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  public Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }
  
  public long countProducts() {
    return productRepository.count();
  }
}
