package by.pvt.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductItemController {

    @Autowired
    ProductCatalogService service;

    @GetMapping("/item/{id}")
    public String showProductItem(@PathVariable Long id, Model model) {
        ProductItem productItem = service.getProductItem(id);
        model.addAttribute("item", productItem);
        return "productItemPage";

    }
}
