package ru.coursework.bibd.Controllers.Spravochniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Spravochniki.SV.SVDao;
import ru.coursework.bibd.Models.Spravochniki.SV;


@Controller
@RequestMapping("/drivers")
public class SVController {
    private SVDao svDao;

    @Autowired
    public SVController(SVDao svDao) {
        this.svDao = svDao;
    }




    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String sv_data) {
        model.addAttribute("sv", svDao.index()); //список всех записей из БД
        model.addAttribute("search", svDao.search(sv_data)); //отдельная запись по критерию поиска
        return "sv/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        svDao.backup();
        return "redirect:/drivers";
    }

    @GetMapping("/restore")
    public String restore(){
        svDao.restore();
        return "redirect:/drivers";
    }
    //endregion


    //region Изменение
    @GetMapping("/{tab_num}/edit")
    public String edit(Model model, @PathVariable("tab_num") String tab_num) {
        model.addAttribute("note", svDao.show(tab_num));
        return "sv/edit";
    }

    @PatchMapping("/{tab_num}")
    public String update(@ModelAttribute("note") SV sv,
                         @PathVariable("tab_num") String tab_num) {
        svDao.update(tab_num, sv);
        return "redirect:/drivers";
    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new SV());
        return "sv/new";
    }


    @PutMapping()
    public String newNote(@ModelAttribute("note") SV sv) {
        svDao.save(sv);
        return "redirect:/drivers";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{tab_num}")
    public String del(@PathVariable("tab_num") String code) {
        svDao.delete(code);
        return "redirect:/drivers";
    }
    //endregion

}
