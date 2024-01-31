package ra.projectmd3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping // khơp với đường dẫn gốc
    public String home(){
        return "home";
    }
}
