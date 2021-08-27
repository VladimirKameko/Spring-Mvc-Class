package by.pvt.user;

import by.pvt.pojo.AppUser;
import by.pvt.pojo.RoleName;
import by.pvt.product.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("roles",userService.getAllRoles());
        return "registerUser";
    }

    @PostMapping
    public String registerForm(@ModelAttribute AppUser user,
                               @RequestParam("role") RoleName role) {
            if(!userService.saveNewUser(user, role)){
                return "error";
            }

        return "redirect:/home";
    }


}
