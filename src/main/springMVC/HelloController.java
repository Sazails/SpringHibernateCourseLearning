package main.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    // show HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloForm";
    }

    // process HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloDisplay";
    }

    // add data to the model
    @RequestMapping("/roastUser")
    public String roastUser(HttpServletRequest request, Model model){

        // read HTML form request
        String name = request.getParameter("userName");

        // create data
        name = name.toUpperCase();

        // create roast
        String result = "You are a funny one " + name;

        // add data to model
        model.addAttribute("message", result);

        return "helloDisplay";
    }
}
