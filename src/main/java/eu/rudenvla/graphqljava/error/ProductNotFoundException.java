package eu.rudenvla.graphqljava.error;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductNotFoundException extends RuntimeException implements GraphQLError {
  
  private Map<String, Object> extensions;
  
  /**
   * Sends error message to frontend if a product does not exist in the database.
   *
   * @param message          - error message
   * @param invalidProductId - product id which does not exist in the database
   */
  public ProductNotFoundException(String message, Long invalidProductId) {
    super(message);
    extensions = new HashMap<>();
    extensions.put("invalidProductId", invalidProductId);
  }
  
  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }
  
  @Override
  public Map<String, Object> getExtensions() {
    return extensions;
  }
  
  @Override
  public ErrorType getErrorType() {
    return ErrorType.DataFetchingException;
  }
}
