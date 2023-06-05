package ru.coursework.bibd.Controllers.Spravochniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Spravochniki.SM.SMDao;
import ru.coursework.bibd.Models.Spravochniki.SM;

@Controller
@RequestMapping("/routes")
public class SMController {
    private SMDao smDao;
    @Autowired
    public SMController(SMDao smDao) {
        this.smDao = smDao;
    }


    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String SM_data) {
        model.addAttribute("sm", smDao.index()); //список всех записей из БД
        model.addAttribute("search", smDao.search(SM_data)); //отдельная запись по критерию поиска
        return "sm/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        smDao.backup();
        return "redirect:/routes";
    }

    @GetMapping("/restore")
    public String restore(){
        smDao.restore();
        return "redirect:/routes";
    }
    //endregion

    //region Изменение
    @GetMapping("/{code_route}/edit")
    public String edit(Model model, @PathVariable("code_route") String code_route) {
        model.addAttribute("note", smDao.show(code_route));
        return "sm/edit";
    }

    @PatchMapping("/{code_route}")
    public String update(@ModelAttribute("note") SM SM,
                         @PathVariable("code_route") String code_route) {
        smDao.update(code_route, SM);
        return "redirect:/routes";
    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new SM());
        return "sm/new";
    }


    @PutMapping()
    public String newNote(@ModelAttribute("note") SM SM) {
        smDao.save(SM);
        return "redirect:/routes";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{code_route}")
    public String del(@PathVariable("code_route") String code) {
        smDao.delete(code);
        return "redirect:/routes";
    }
    //endregion
}
