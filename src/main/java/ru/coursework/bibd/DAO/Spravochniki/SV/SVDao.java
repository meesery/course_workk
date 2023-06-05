package ru.coursework.bibd.DAO.Spravochniki.SV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Spravochniki.SV;

import java.util.List;

@Component
public class SVDao implements IDao<SV> {
   private JdbcTemplate jdbcTemplate;
   @Autowired
    public SVDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SV> index() {
        return jdbcTemplate.query("Select * from \"SV\"",new SVRowMapper());
    }

    @Override
    public SV show(String code) {
        return jdbcTemplate.query("Select * from \"SV\" where tab_num = ?", new Object[]{code}, new SVRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(SV obj) {
       String sql = "INSERT INTO \"SV\" (tab_num, fio_driv, date_birth, drlic_date, valid_date, passport_num, drlic_cat,drlic_num)" +
               " values (?,?,?,?,?,?,?,?);";
         jdbcTemplate.update(sql, obj.getTabNum(),
                                        obj.getFio(),
                                        obj.getDateOfBirth(),
                                        obj.getDateOfDrLic(),
                                        obj.getDateOfValid(),
                                        obj.getPassNum(),
                                        obj.getDriverCat(),
                                        obj.getLicNum());
    }

    @Override
    public SV search(String codeOrName) {
        return jdbcTemplate.query("Select * from \"SV\" where tab_num = ? OR fio_driv = ?", new Object[]{codeOrName, codeOrName}, new SVRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(String code, SV updatedObj) {
        String sql = "update \"SV\" set tab_num = ?, fio_driv=?, date_birth=?, drlic_date=?, valid_date=?, passport_num=?, drlic_cat=?,drlic_num=? where tab_num = ?";
        jdbcTemplate.update(sql, updatedObj.getTabNum(),
                                 updatedObj.getFio(),
                                 updatedObj.getDateOfBirth(),
                                 updatedObj.getDateOfDrLic(),
                                 updatedObj.getDateOfValid(),
                                 updatedObj.getPassNum(),
                                 updatedObj.getDriverCat(),
                                 updatedObj.getLicNum(),
                                 code);
    }

    @Override
    public void delete(String code) {
        jdbcTemplate.update("delete from \"SV\" where tab_num=?", code);
    }

    String backupFile = "sv_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"SV\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"SV\" *; copy \"SV\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }


}
