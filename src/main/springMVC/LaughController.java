package main.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaughController {

    @RequestMapping("/showForm")
    public String displayForm(){
        return "laugh";
    }
}
