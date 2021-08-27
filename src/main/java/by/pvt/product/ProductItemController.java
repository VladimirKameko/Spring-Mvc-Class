package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("item/{id}/image")
    public @ResponseBody
    byte[] showProductImage(@PathVariable Long id){
       return service.getProductItem(id).getPicture();
    }
}
