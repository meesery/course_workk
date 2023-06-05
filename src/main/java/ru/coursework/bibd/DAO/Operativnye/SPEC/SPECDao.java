package ru.coursework.bibd.DAO.Operativnye.SPEC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Operativnye.Spec;

import java.util.List;

@Component
public class SPECDao implements IDao<Spec> {
private JdbcTemplate jdbcTemplate;
@Autowired
    public SPECDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Spec> index() {
        String sql = "Select * from \"SPEC\"";
        return jdbcTemplate.query(sql, new SPECRowMapper());
    }



    @Override
    public void save(Spec spec) {
    String sql = "insert into \"SPEC\" (num_spec, date_spec, code_izd, name_izd,amount, code_route) values (?,?,?,?,?,?);" +
            " update \"SPEC\" set (name_izd, ed_izm, weight_izd, volume_izd, price_izd) = " +
            "(select name_izd, ed_izm,weight_izd,volume_izd,price_izd from \"SSI\" where code_izd = ?) where num_spec=?";
    jdbcTemplate.update(sql, spec.getNumSpec(),
                             spec.getDateSpec(),
                             spec.getCodeIzd(),
                                spec.getNameIzd(),
                                spec.getAmount(),
                                spec.getCodeRoute(),
             spec.getCodeIzd(), spec.getNumSpec());
    }

    @Override
    public Spec search(int num) {
            return jdbcTemplate.query("Select * from \"SPEC\" where num_spec=?", new Object[]{num}, new SPECRowMapper())
                    .stream().findAny().orElse(null);
        }
    @Override
    public void update(int id, Spec updatedObj) {
        String sql = "update \"SPEC\" set num_spec=?, date_spec=?, code_izd=?, name_izd=?,amount=?, code_route=? where num_spec = ?;" +
                     "update \"SPEC\" set (name_izd, ed_izm, weight_izd, volume_izd, price_izd) = " +
                     "(select name_izd, ed_izm,weight_izd,volume_izd,price_izd from \"SSI\" where code_izd = ?) where num_spec = ?";
        jdbcTemplate.update(sql, updatedObj.getNumSpec(),
                                 updatedObj.getDateSpec(),
                                 updatedObj.getCodeIzd(),
                                 updatedObj.getNameIzd(),
                                 updatedObj.getAmount(),
                                 updatedObj.getCodeRoute(),
                                 id,
                                 updatedObj.getCodeIzd(),updatedObj.getNumSpec());
}

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from \"SPEC\" where num_spec = ?", id);
    }

    String backupFile = "spec_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"SPEC\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"DP\" *; copy \"SPEC\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }

}
