package ru.coursework.bibd.Controllers.Operativnye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Operativnye.JOURN.JournDAO;
import ru.coursework.bibd.Models.Operativnye.Journ;

@Controller
@RequestMapping("/journ")
public class JournController {
    public JournDAO journDAO;
    @Autowired
    public JournController(JournDAO journDAO) {
        this.journDAO = journDAO;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String Req_data) {
        model.addAttribute("jour", journDAO.index());
        model.addAttribute("search", journDAO.search(Req_data));
        return "journ/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        journDAO.backup();
        return "redirect:/journ";
    }

    @GetMapping("/restore")
    public String restore(){
        journDAO.restore();
        return "redirect:/journ";
    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new Journ());
        return "journ/new";
    }

    @PostMapping()
    public String newNote(@ModelAttribute("note") Journ journ) {
        journDAO.save(journ);
        return "redirect:/journ";
    }
    //endregion

    //region Изменение
    @GetMapping("/{jour_num}/edit")
    public String edit(Model model, @PathVariable("jour_num") String jour_num) {
        model.addAttribute("note", journDAO.search(jour_num));
        return "journ/edit";
    }

    @PatchMapping("/{jour_num}")
    public String update(@ModelAttribute("note") Journ journ,
                         @PathVariable("jour_num") String jour_num) {
        journDAO.update(jour_num, journ);
        return "redirect:/journ";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{jour_num}")
    public String del(@PathVariable("jour_num") String num) {
        journDAO.delete(num);
        return "redirect:/journ";
    }
    //endregion
}
