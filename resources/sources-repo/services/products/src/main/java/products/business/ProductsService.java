package products.business;

import products.business.ports.persistence.ProductsPersistenceService;
import products.business.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsPersistenceService productsPersistenceService;

    public ProductsService(ProductsPersistenceService productsPersistenceService) {
        this.productsPersistenceService = productsPersistenceService;
    }

    public List<Product> getProducts(List<String> labels) {
        return this.productsPersistenceService.fetchByLabels(labels);
    }
}
