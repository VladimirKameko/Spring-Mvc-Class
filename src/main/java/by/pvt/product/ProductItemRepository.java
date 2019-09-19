package by.pvt.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductItemRepository {

    static List<ProductItem> catalog = new ArrayList<>();

    static {
        catalog.add(new ProductItem(1L, "Nokia 3310", true, 100.45));
        catalog.add(new ProductItem(2L, "Samsung S10", false, 1599.99));
        catalog.add(new ProductItem(3L, "Xiomi", false, 850.00));
        catalog.add(new ProductItem(4L, "Iphone X", true, 1300.99));
        catalog.add(new ProductItem(5L, "HTC", true, 2100.88));
        catalog.add(new ProductItem(6L, "ZTE", false, 1599.99));

    }

    public List<ProductItem> findProduct(int count, boolean isTopProduct) {

        return catalog.stream()
                .filter(ProductItem::isTopProduct)
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<ProductItem> findProductByName(String serchStr) {
        return catalog.stream()
                .filter(productItem -> productItem.getName().toLowerCase().contains(serchStr.toLowerCase()))
                .collect(Collectors.toList());
    }

    public ProductItem findProductById(Long id) {
        return catalog.stream()
                .filter(productItem -> productItem.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public void save(ProductItem productItem) {
        catalog.add(productItem);
    }
}
