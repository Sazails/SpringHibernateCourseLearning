package main.springMVC.Controller;

import main.springMVC.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Value("#{magicOptions}")
    private Map<String, String> magicOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model){

        // Create user object
        User user = new User();

        // Add user object to model
        model.addAttribute("user", user);

        // Add magic options to model
        model.addAttribute("magicOptions", magicOptions);

        return "userForm";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User student){
        return "userConfirm";
    }

}
