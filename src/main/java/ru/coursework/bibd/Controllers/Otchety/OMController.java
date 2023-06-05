package ru.coursework.bibd.Controllers.Otchety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.coursework.bibd.DAO.Otchety.OMDao;

@Controller
@RequestMapping("/routereport")
public class OMController {
public OMDao omDao;

@Autowired
    public OMController(OMDao omDao) {
        this.omDao = omDao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "month", required = false,defaultValue = "0") Integer month,
                                     @RequestParam(value = "year", required = false,defaultValue = "0") Integer year) {
        model.addAttribute("om", omDao.report(month,year));
        return "om/index";
    }




}
