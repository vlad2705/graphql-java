package eu.rudenvla.graphqljava.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import eu.rudenvla.graphqljava.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductResolver implements GraphQLResolver<Product> {
}
