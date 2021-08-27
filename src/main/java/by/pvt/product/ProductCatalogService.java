package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
public class ProductCatalogService {
    @Autowired
    ProductItemRepository repository;

    @Transactional
    public List<ProductItem> getTopProducts() {

        return repository.findProduct(6, true);

    }

    @Transactional
    public List<ProductItem> searchProduct(String searchStr) {
        return repository.findProductByName(searchStr);
    }

    @Transactional
    public ProductItem getProductItem(Long id) {
        return repository.findProductById(id);
    }

    @Transactional
    public void saveNewProduct(ProductItem productItem) {
        if(productItem.getUpdateDate()==null){
            productItem.setUpdateDate(new Date());
        }

        repository.save(productItem);
    }

}



