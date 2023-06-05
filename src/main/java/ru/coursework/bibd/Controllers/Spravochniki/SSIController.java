package ru.coursework.bibd.Controllers.Spravochniki;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Spravochniki.SSI.SSIDao;
import ru.coursework.bibd.Models.Spravochniki.SSI;

@Controller
@RequestMapping("/stroyizd")
public class SSIController {
    private SSIDao ssiDao;

    @Autowired
    public SSIController(SSIDao ssiDao) {
        this.ssiDao = ssiDao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String ssi_data) {
        model.addAttribute("ssi", ssiDao.index()); //список всех записей из БД
        model.addAttribute("search", ssiDao.search(ssi_data)); //отдельная запись по критерию поиска
        return "ssi/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        ssiDao.backup();
        return "redirect:/stroyizd";
    }

    @GetMapping("/restore")
    public String restore(){
        ssiDao.restore();
        return "redirect:/stroyizd";
    }
    //endregion
    //region Изменение
    @GetMapping("/{code_izd}/edit")
    public String edit(Model model, @PathVariable("code_izd") String code_izd) {
        model.addAttribute("note", ssiDao.show(code_izd));
        return "ssi/edit";
    }

    @PatchMapping("/{code_izd}")
    public String update(@ModelAttribute("note") @Valid SSI ssi,BindingResult bindingResult,
                         @PathVariable("code_izd") String code_izd) {
        if (bindingResult.hasErrors())
            return "ssi/edit";

        ssiDao.update(code_izd, ssi);
        return "redirect:/stroyizd";

    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new SSI());
        return "ssi/new";
    }


    @PutMapping()
    public String newNote(@ModelAttribute("note") @Valid SSI ssi, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "ssi/new";
        ssiDao.save(ssi);
        return "redirect:/stroyizd";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{code_izd}")
    public String del(@PathVariable("code_izd") String code) {
        ssiDao.delete(code);
        return "redirect:/stroyizd";
    }
    //endregion


}

