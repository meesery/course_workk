package ru.coursework.bibd.Controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class LoginController {


    String login ="";
    String password="";
    @GetMapping()
    public String login(Model model, @RequestParam(value = "login", required = false) String _login,
                        @RequestParam(value = "password", required = false) String _password){
             model.addAttribute("log", _login);
             model.addAttribute("pass", _password);

             if (login.equals("admin") && password.equals("admin"))
                 return "index";
             else
                 return "loging";
    }

    @PostMapping()
    public String submit(@ModelAttribute("login") String _login, @ModelAttribute("password") String _password) {
       login = _login;
       password= _password;
       return "redirect:/";
    }
}
