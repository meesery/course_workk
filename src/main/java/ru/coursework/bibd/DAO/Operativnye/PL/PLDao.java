package ru.coursework.bibd.DAO.Operativnye.PL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.DAO.Otchety.OMRowMapper;
import ru.coursework.bibd.Models.Operativnye.PL;
import ru.coursework.bibd.Models.Otchety.OM;

import java.util.List;

@Component
public class PLDao implements IDao<PL> {
    private JdbcTemplate jdbcTemplate;
@Autowired
    public PLDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PL> index() {
        return jdbcTemplate.query("Select * from \"PL\";", new PLRowMapper());
    }

    @Override
    public void save(PL obj) {
  String sql = "insert into \"PL\" (num_pl, date_pl, auto_num, drlic_num, date_start, date_finish, code_route, code_izd)" +
                            "values (?,?,?,?,?,?,?,?);" +
          "Update \"PL\" set fio_driv = (select fio_driv from \"SV\" where drlic_num=?) where num_pl=?;" +
          "Update \"PL\" set auto_mark = (select auto_mark from \"SA\" where auto_num=?) where num_pl=?;" +
          "Update \"PL\" set (probeg,addr_route) = (select len_route, addr_route from \"SM\" where code_route=?) where num_pl=? and code_route=?;" +
          "Update \"PL\" set (weight, price) = (select weight_full,price_full from \"SPEC\" where code_izd=?) where num_pl=?;";
jdbcTemplate.update(sql, obj.getNumPl(),obj.getDatePl(), obj.getNumAuto(), obj.getNumLic(), obj.getDateStart(), obj.getDateFinish(),
        obj.getCodeRoute(), obj.getCodeIzd(), obj.getNumLic(), obj.getNumPl(), obj.getNumAuto(), obj.getNumPl(),
        obj.getCodeRoute(), obj.getNumPl(),obj.getCodeRoute(), obj.getCodeIzd(), obj.getNumPl());
}



    @Override
    public PL search(String codeOrName) {
        return jdbcTemplate.query("select * from \"PL\" where num_pl=?", new Object[]{codeOrName}, new PLRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(String code, PL updatedObj) {
        IDao.super.update(code, updatedObj);
    }

    @Override
    public void delete(String code) {
        jdbcTemplate.update("delete from \"PL\" where num_pl=?", code);
    }

    String backupFile = "pl_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"PL\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"PL\" *; copy \"PL\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }
}
