package ru.coursework.bibd.DAO.Operativnye.JOURN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Operativnye.Journ;

import java.util.List;

@Component
public class JournDAO implements IDao<Journ> {
    private JdbcTemplate jdbcTemplate;
@Autowired
    public JournDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Journ> index() {
        return jdbcTemplate.query("Select * from \"JOURN\"", new JournRowMapper());
    }

    @Override
    public Journ show(String code) {
        return jdbcTemplate.query("Select * from \"JOURN\" where num_req=?", new Object[]{code}, new JournRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(Journ obj) {
    String sql = "INSERT  into \"JOURN\"(num_req,date_req,date_plan) values(?,?,?);" +
            "update \"JOURN\" set tel = (select tel from \"REQ\" where num_req=? ) where num_req=? ;";
            jdbcTemplate.update(sql, obj.getNumReq(), obj.getDateReq(),obj.getDatePlanl(),obj.getNumReq(),obj.getNumReq());
    }

    @Override
    public Journ search(String codeOrName) {
        return jdbcTemplate.query("Select * from \"JOURN\" where num_req=?", new Object[]{codeOrName}, new JournRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(String code, Journ updatedObj) {
    String sql = "update  \"JOURN\" set num_req=?, date_req=?, date_plan=?, tel=? where num_req=?";
    jdbcTemplate.update(sql, updatedObj.getNumReq(),
                             updatedObj.getDateReq(),
                             updatedObj.getDatePlanl(),
                             updatedObj.getTel(),
                             code);

    }

    @Override
    public void delete(String code) {
        jdbcTemplate.update("delete from \"JOURN\" where num_req=?", code);
    }

    String backupFile = "journ_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"JOURN\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"JOURN\" *; copy \"JOURN\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }
}
