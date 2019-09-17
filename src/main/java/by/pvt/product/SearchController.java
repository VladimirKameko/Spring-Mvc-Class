package by.pvt.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    ProductCatalogService catalogService;

    @GetMapping
    public String search(@RequestParam String searchStr, Model model) {

        List<ProductItem> items = catalogService.searchProduct(searchStr);
        model.addAttribute("items", items);
        return "searchResultPage";
    }
}
