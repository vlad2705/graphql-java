package eu.rudenvla.graphqljava.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import eu.rudenvla.graphqljava.error.ProductNotFoundException;
import eu.rudenvla.graphqljava.model.Product;
import eu.rudenvla.graphqljava.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Mutations to create, update, and delete data.
 */
@Service
public class Mutation implements GraphQLMutationResolver {
  private final ProductRepository productRepository;
  
  @Autowired
  public Mutation(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  /**
   * Create a new {@link Product} object.
   *
   * @param name        of the product
   * @param price       of the product
   * @param description of the product
   * @return {@link Product} object with ID
   */
  public Product newProduct(String name, BigDecimal price, String description) {
    Product product = new Product();
    product.setName(name);
    product.setPrice(price);
    product.setDescription(description);
    productRepository.save(product);
    return product;
  }
  
  /**
   * Update a product name.
   *
   * @param newName is a new name of the product
   * @param id      of the product
   * @return the updated product
   */
  public Product updateProductName(String newName, Long id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      throw new ProductNotFoundException("The product to be updated was not found", id);
    }
    product.get().setName(newName);
    
    productRepository.save(product.get());
    
    return product.get();
  }
  
  /**
   * Deletes a product by ID.
   *
   * @param id - product ID
   */
  public Boolean deleteProduct(Long id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      throw new ProductNotFoundException("The product to be updated was not found", id);
    }
    productRepository.delete(product.get());
    return true;
  }
}
