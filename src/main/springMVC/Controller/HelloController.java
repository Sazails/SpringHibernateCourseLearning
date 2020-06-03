package main.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
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
    @RequestMapping("/roastUserOne")
    public String roastUser(HttpServletRequest request, Model model){

        // read HTML form request
        String name = request.getParameter("userName");

        // modify data
        name = name.toUpperCase();

        // create roast
        String result = "You are a funny one " + name;

        // add data to model
        model.addAttribute("message", result);

        return "helloDisplay";
    }

    @RequestMapping("/roastUserTwo")
    public String roastUserTwo(@RequestParam("userName") String theName, Model model){

        // modify data
        theName = theName.toUpperCase();

        // create roast
        String result = "You are a funny one " + theName;

        // add data to model
        model.addAttribute("message", result);

        return "helloDisplay";
    }
}
