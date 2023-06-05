package ru.coursework.bibd.DAO.Spravochniki.SM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Spravochniki.SM;

import java.util.List;

@Component
public class SMDao implements IDao<SM> {
    private JdbcTemplate jdbcTemplate;
@Autowired
    public SMDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SM> index() {
        return jdbcTemplate.query("Select * from \"SM\"", new SMRowMapper());
    }

    @Override
    public SM show(String code) {
        return jdbcTemplate.query("select * from \"SM\" where code_route=?", new Object[]{code},new SMRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(SM obj) {
        jdbcTemplate.update("insert into \"SM\" (code_route, addr_route, len_route) values(?,?,?)",
                                obj.getCodeRoute(),
                                obj.getAddrRoute(),
                                obj.getLenRoute());
    }

    @Override
    public SM search(String codeOrName) {
        return jdbcTemplate.query("select * from \"SM\" where code_route=?", new Object[]{codeOrName},new SMRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(String code, SM updatedObj) {
        jdbcTemplate.update("update \"SM\" set code_route=?, addr_route=?, len_route=? where code_route= ?",
                updatedObj.getCodeRoute(),
                updatedObj.getAddrRoute(),
                updatedObj.getLenRoute(), code);
    }

    @Override
    public void delete(String code) {
        jdbcTemplate.update("delete from \"SM\" where code_route=?", code);
    }

    String backupFile = "sm_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"SM\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"SM\" *; copy \"SM\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }
}
