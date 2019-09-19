package by.pvt.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add")
public class AddProductController {

    private static Logger logger= Logger.getLogger("AddProductController");
    @Autowired
    ProductCatalogService productCatalogService;

    @GetMapping
    public String showAddPage() {
        return "addPage";
    }

    @PostMapping("/product")
    public String addNewProduct(
            @ModelAttribute("item") ProductItem productItem,
            @RequestParam("image") MultipartFile file) throws IOException {

        logger.info("New product" + productItem);
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            productItem.setPicture(bytes);
            productCatalogService.saveNewProduct(productItem);
            return "redirect:/home";
        }

        return "error";
    }


}
