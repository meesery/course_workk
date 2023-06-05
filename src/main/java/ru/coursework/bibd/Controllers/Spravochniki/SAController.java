package ru.coursework.bibd.Controllers.Spravochniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Spravochniki.SA.SADao;
import ru.coursework.bibd.Models.Spravochniki.SA;

@Controller
@RequestMapping("/auto")
public class SAController {
    private SADao SADao;

    @Autowired
    public SAController(SADao SADao) {
        this.SADao = SADao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String SA_data) {
        model.addAttribute("sa", SADao.index()); //список всех записей из БД
        model.addAttribute("search", SADao.search(SA_data)); //отдельная запись по критерию поиска
        return "sa/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        SADao.backup();
        return "redirect:/auto";
    }

    @GetMapping("/restore")
    public String restore(){
        SADao.restore();
        return "redirect:/auto";
    }
    //endregion

    //region Изменение
    @GetMapping("/{auto_num}/edit")
    public String edit(Model model, @PathVariable("auto_num") String auto_num) {
        model.addAttribute("note", SADao.show(auto_num));
        return "sa/edit";
    }

    @PatchMapping("/{auto_num}")
    public String update(@ModelAttribute("note") SA SA,
                         @PathVariable("auto_num") String auto_num) {
        SADao.update(auto_num, SA);
        return "redirect:/auto";
    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new SA());
        return "sa/new";
    }


    @PutMapping()
    public String newNote(@ModelAttribute("note") SA SA) {
        SADao.save(SA);
        return "redirect:/auto";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{auto_num}")
    public String del(@PathVariable("auto_num") String code) {
        SADao.delete(code);
        return "redirect:/auto";
    }
    //endregion
}
