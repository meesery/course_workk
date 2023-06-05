package ru.coursework.bibd.Controllers.Operativnye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coursework.bibd.DAO.Operativnye.REQ.ReqDAO;
import ru.coursework.bibd.Models.Operativnye.Req;

@Controller
@RequestMapping("/request")
public class ReqController {
    public ReqDAO reqDao;
    @Autowired
    public ReqController(ReqDAO reqDao) {
        this.reqDao = reqDao;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false, defaultValue = "0") String Req_data) {
        model.addAttribute("req", reqDao.index());
        model.addAttribute("search", reqDao.search(Req_data));
        return "req/index";
    }

    //region Сохранение и восстановление информации
    @GetMapping("/backup")
    public String  backup(){
        reqDao.backup();
        return "redirect:/request";
    }

    @GetMapping("/restore")
    public String restore(){
        reqDao.restore();
        return "redirect:/request";
    }
    //endregion

    //region Добавление
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("note", new Req());
        return "req/new";
    }

    @PostMapping()
    public String newNote(@ModelAttribute("note") Req Req) {
        reqDao.save(Req);
        return "redirect:/request";
    }
    //endregion

    //region Изменение
    @GetMapping("/{num_req}/edit")
    public String edit(Model model, @PathVariable("num_req") String num_Req) {
        model.addAttribute("note", reqDao.search(num_Req));
        return "req/edit";
    }

    @PatchMapping("/{num_req}")
    public String update(@ModelAttribute("note") Req Req,
                         @PathVariable("num_req") String num_Req) {
        reqDao.update(num_Req, Req);
        return "redirect:/request";
    }
    //endregion

    //region Удаление
    @DeleteMapping("/{num_req}")
    public String del(@PathVariable("num_req") String num) {
        reqDao.delete(num);
        return "redirect:/request";
    }
    //endregion

}
