package by.pvt.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class ProductCatalogService {
    @Autowired
    ProductItemRepository repository;

    List<ProductItem> getTopProducts(){

        return repository.findProduct(4,true);

    }

    public List<ProductItem> searchProduct(String searchStr) {
        return repository.findProductByName(searchStr);
    }


    public ProductItem getProductItem(Long id) {
        return repository.findProductById(id);
    }

    public void saveNewProduct(ProductItem productItem) {
        repository.save(productItem);
    }
}
