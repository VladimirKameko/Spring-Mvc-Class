package by.pvt.product;

import by.pvt.pojo.ProductItem;
import by.pvt.pojo.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add")
public class AddProductController {

    private static Logger logger = Logger.getLogger("AddProductController");
    @Autowired
    ProductCatalogService productCatalogService;

    @Autowired
    ProductItemValidator validator;



    @GetMapping
    public String showAddPage() {
        logger.info("Call to addPage");
        return "addPage";
    }

    @PostMapping("/product")
    public String addNewProduct(
            @ModelAttribute("item") ProductItem productItem,
            @RequestParam("image") MultipartFile file,
            @RequestParam(value = "isTopProduct", required = false) boolean s,
            BindingResult result, Model model) throws IOException {

        logger.info("New product" + productItem + s);
        validator.validate(productItem,result);
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "addPage";
        }
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();

            productItem.setPicture(bytes);

            productItem.setTopProduct(s);

            productCatalogService.saveNewProduct(productItem);

            return "redirect:/home";
        }
        logger.info("New product" + productItem);

        return "error";


    }


}
