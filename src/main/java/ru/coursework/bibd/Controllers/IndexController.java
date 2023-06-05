package ru.coursework.bibd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/spravka")
    public String spr(){
        return "spravka";
    }
}
