package ru.coursework.bibd.DAO.Spravochniki.SA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Spravochniki.SA;

import java.util.List;

@Component
public class SADao implements IDao<SA> {
   private JdbcTemplate jdbcTemplate;
   @Autowired
    public SADao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SA> index() {
        return jdbcTemplate.query("Select * from \"SA\"",new SARowMapper());
    }

    @Override
    public SA show(String code) {
        return jdbcTemplate.query("Select * from \"SA\" where auto_num = ?", new Object[]{code}, new SARowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(SA obj) {
       String sql = "INSERT INTO \"SA\" (auto_num," +
                                         "auto_mark," +
                                         "load_cap," +
                                         "year_prod," +
                                         "first_cost," +
                                         "code_am," +
                                         "perc_am," +
                                         "srok_isp) " +
                                         " values (?,?,?,?,?,?,?,?);";
         jdbcTemplate.update(sql,       obj.getAutoNum(),
                                        obj.getAutoMark(),
                                        obj.getLoadCap(),
                                        obj.getYearProd(),
                                        obj.getFirstCost(),
                                        obj.getCodeAm(),
                                        obj.getPercAm(),
                                        obj.getSrokIsp());
   }


    @Override
    public SA search(String codeOrName) {
        return jdbcTemplate.query("Select * from \"SA\" where auto_num = ? OR auto_mark = ?", new Object[]{codeOrName, codeOrName}, new SARowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(String code, SA updatedObj) {
        String sql = "update \"SA\" set auto_num=?," +
                                     "auto_mark=?," +
                                     "load_cap=?," +
                                     "year_prod=?," +
                                     "first_cost=?," +
                                     "code_am=?," +
                                     "perc_am=?," +
                                     "srok_isp=? " +
                                     "where auto_num = ?";
        jdbcTemplate.update(sql, updatedObj.getAutoNum(),
                                 updatedObj.getAutoMark(),
                                 updatedObj.getLoadCap(),
                                 updatedObj.getYearProd(),
                                 updatedObj.getFirstCost(),
                                 updatedObj.getCodeAm(),
                                 updatedObj.getPercAm(),
                                 updatedObj.getSrokIsp(),
                                 code);

    }

    @Override
    public void delete(String code) {
        jdbcTemplate.update("delete from \"SA\" where auto_num=?", code);
    }
    String backupFile = "sa_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"SA\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"SA\" *; copy \"SA\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }

}
