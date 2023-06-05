package ru.coursework.bibd.Controllers.Operativnye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Operativnye.SPEC.SPECDao;
import ru.coursework.bibd.Models.Operativnye.Spec;

@Controller
@RequestMapping("/specif")
public class SPECController {
    public SPECDao specDao;
    @Autowired
    public SPECController(SPECDao specDao) {
        this.specDao = specDao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false, defaultValue = "0") Integer spec_data) {
        model.addAttribute("spec", specDao.index());
        model.addAttribute("search", specDao.search(spec_data));
        return "spec/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        specDao.backup();
        return "redirect:/specif";
    }

    @GetMapping("/restore")
    public String restore(){
        specDao.restore();
        return "redirect:/specif";
    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new Spec());
        return "spec/new";
    }

    @PostMapping()
    public String newNote(@ModelAttribute("note") Spec spec) {
        specDao.save(spec);
        return "redirect:/specif";
    }
    //endregion

    //region Изменение
    @GetMapping("/{num_spec}/edit")
    public String edit(Model model, @PathVariable("num_spec") int num_spec) {
        model.addAttribute("note", specDao.search(num_spec));
        return "spec/edit";
    }

    @PatchMapping("/{num_spec}")
    public String update(@ModelAttribute("note") Spec spec,
                         @PathVariable("num_spec") int num_spec) {
        specDao.update(num_spec, spec);
        return "redirect:/specif";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{num_spec}")
    public String del(@PathVariable("num_spec") int num) {
        specDao.delete(num);
        return "redirect:/specif";
    }
    //endregion


}
