package by.pvt;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/home")
public class HomeController {

    private static Logger logger = Logger.getLogger("HomeController");

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage() {
        logger.info("Call showHomePage");
        return "homePage";

    }


}
