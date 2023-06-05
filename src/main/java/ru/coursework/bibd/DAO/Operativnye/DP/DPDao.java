package ru.coursework.bibd.DAO.Operativnye.DP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Operativnye.DP;

import java.util.List;

@Component
public class DPDao implements IDao<DP> {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DPDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DP> index() {
        return jdbcTemplate.query("Select * from \"DP\"", new DPRowMapper());
    }

    @Override
    public DP show(String code) {
        return jdbcTemplate.query("Select * from \"DP\" where num_plan=?", new Object[]{code}, new DPRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(DP obj) {
        String sql = "insert into \"DP\" (num_plan, date_plan, num_req, date_req, tab_num, date_start)" +
                " values(?,?,?,?,?,?);" +
                "Update \"DP\" set(code_izd, code_route) = (select code_izd, code_route from \"REQ\" where num_req=?) where num_plan=?;";

        jdbcTemplate.update(sql, obj.getNumPlan(),
                obj.getDatePlan(),
                obj.getNumReq(),
                obj.getDateReq(),
                obj.getTabNum(),
                obj.getDateStart(),
                obj.getNumReq(), obj.getNumPlan());
    }

    @Override
    public DP search(String codeOrName) {
        return jdbcTemplate.query("Select * from \"DP\" where num_plan=?", new Object[]{codeOrName}, new DPRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(String code, DP updatedObj) {
        String sql = "Update \"DP\" set num_plan=?, date_plan=?, num_req=?, date_req=?, tab_num=?, date_start=? where num_plan=?;" +
                "Update \"DP\" set(code_izd, code_route) = (select code_izd, code_route from \"REQ\" where num_req=?) where num_plan=?;";
       jdbcTemplate.update(sql, updatedObj.getNumPlan(),
                                updatedObj.getDatePlan(),
                                updatedObj.getNumReq(),
                                updatedObj.getDateReq(),
                                updatedObj.getTabNum(),
                                updatedObj.getDateStart(),
                                code,
                                updatedObj.getNumReq(), updatedObj.getNumPlan());
    }

    @Override
    public void delete(String code) {
       jdbcTemplate.update("delete from \"REQ\" where num_plan=?", code);
    }

   String backupFile = "dp_backup.csv';";

    public void backup(){
        jdbcTemplate.execute("copy \"DP\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"DP\" *; copy \"DP\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }
}
