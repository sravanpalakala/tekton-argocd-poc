package products.business.ports.persistence;

import products.business.model.Product;

import java.util.List;

public interface ProductsPersistenceService {

    List<Product> fetchByLabels(List<String> labels);
}
