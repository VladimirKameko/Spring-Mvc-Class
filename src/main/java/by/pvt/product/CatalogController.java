package by.pvt.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private static Logger logger = Logger.getLogger("CatalogController");

    @RequestMapping(method = RequestMethod.GET)
    public String ShowCatalog(Model model){
        return "catalog";
    }



}
