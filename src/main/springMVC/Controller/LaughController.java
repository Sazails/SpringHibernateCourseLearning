package main.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lll")
public class LaughController {

    @RequestMapping("/showForm")
    public String displayForm(){
        return "laugh";
    }
}
