package ru.coursework.bibd.Controllers.Operativnye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Operativnye.PL.PLDao;
import ru.coursework.bibd.Models.Operativnye.PL;


@Controller
@RequestMapping("/plist")
public class PLController {
    public PLDao plDao;
    @Autowired
    public PLController(PLDao plDao) {
     this.plDao = plDao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String Req_data) {
        model.addAttribute("pl", plDao.index());
        model.addAttribute("search", plDao.search(Req_data));
        return "pl/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        plDao.backup();
        return "redirect:/plist";
    }

    @GetMapping("/restore")
    public String restore(){
        plDao.restore();
        return "redirect:/plist";
    }
    //endregion


    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new PL());
        return "pl/new";
    }

    @PostMapping()
    public String newNote(@ModelAttribute("note") PL pl) {
        plDao.save(pl);
        return "redirect:/plist";
    }
    //endregion

    //region Изменение
    @GetMapping("/{num_pl}/edit")
    public String edit(Model model, @PathVariable("num_pl") String numPL) {
        model.addAttribute("note", plDao.search(numPL));
        return "pl/edit";
    }

    @PatchMapping("/{num_pl}")
    public String update(@ModelAttribute("note") PL pl,
                         @PathVariable("num_pl") String numPl) {
        plDao.update(numPl , pl);
        return "redirect:/plist";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{num_pl}")
    public String del(@PathVariable("num_pl") String num) {
        plDao.delete(num);
        return "redirect:/plist";
    }
    //endregion
}
