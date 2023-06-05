package ru.coursework.bibd.Controllers.Operativnye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Operativnye.DP.DPDao;
import ru.coursework.bibd.Models.Operativnye.DP;
import ru.coursework.bibd.Models.Operativnye.Req;

@Controller
@RequestMapping("/daily")
public class DPController {
    public DPDao dpDao;
    @Autowired
    public DPController(DPDao dpDao) {
        this.dpDao = dpDao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String Req_data) {
        model.addAttribute("dp", dpDao.index());
        model.addAttribute("search", dpDao.search(Req_data));
        return "dp/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        dpDao.backup();
        return "redirect:/daily";
    }

    @GetMapping("/restore")
    public String restore(){
        dpDao.restore();
        return "redirect:/daily";
    }
    //endregion


    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new DP());
        return "dp/new";
    }

    @PostMapping()
    public String newNote(@ModelAttribute("note") DP dp) {
        dpDao.save(dp);
        return "redirect:/daily";
    }
    //endregion

    //region Изменение
    @GetMapping("/{num_req}/edit")
    public String edit(Model model, @PathVariable("num_req") String num_Req) {
        model.addAttribute("note", dpDao.search(num_Req));
        return "dp/edit";
    }

    @PatchMapping("/{num_req}")
    public String update(@ModelAttribute("note") DP dp,
                         @PathVariable("num_req") String num_Req) {
        dpDao.update(num_Req, dp);
        return "redirect:/daily";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{num_req}")
    public String del(@PathVariable("num_req") String num) {
        dpDao.delete(num);
        return "redirect:/daily";
    }
    //endregion
}
