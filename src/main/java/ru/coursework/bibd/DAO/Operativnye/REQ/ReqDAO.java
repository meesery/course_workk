package ru.coursework.bibd.DAO.Operativnye.REQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Operativnye.Req;

import java.util.List;

@Component
public class ReqDAO implements IDao<Req> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ReqDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Req> index() {
        return jdbcTemplate.query("Select * from \"REQ\"", new ReqRowMapper());
    }

    @Override
    public Req show(String code) {
        String sql = "Select * from \"REQ\" where num_req=? ";
        return jdbcTemplate.query(sql,new Object[]{code}, new ReqRowMapper()).stream().findAny().orElse(null);
    }

    @Override
    public void save(Req obj) {
        String sql = "Insert into \"REQ\"(num_req, date_req, num_spec, date_spec, dest, price_trans, tel) " +
                                "values (?,?,?,?,?,?,?); " +
                     "Update \"REQ\" set (code_route, code_izd) = " +
                     "(select code_route, code_izd from \"SPEC\" where num_spec=?) where num_req=?";
        jdbcTemplate.update(sql, obj.getNumReq(),
                obj.getDate_req(),
                obj.getNum_spec(),
                obj.getDate_spec(),
                obj.getDest(),
                obj.getPrice_trans(),
                obj.getTel(),
                obj.getNum_spec(),obj.getNumReq());
    }

    @Override
    public Req search(String codeOrName) {
        String sql = "Select * from \"REQ\" where num_req=? ";
        return jdbcTemplate.query(sql,new Object[]{codeOrName}, new ReqRowMapper()).stream().findAny().orElse(null);

    }

    @Override
    public void update(String code, Req updatedObj) {
        String sql = "Update \"REQ\" set num_req=?, date_req=?, num_spec=?, date_spec=?, dest=?, price_trans=?, tel=? where num_req=?; " +
                "Update \"REQ\" set (code_route, code_izd) = " +
                "(select code_route, code_izd from \"SPEC\" where num_spec=?) where num_req=?";
        jdbcTemplate.update(sql, updatedObj.getNumReq(),
                                 updatedObj.getDate_req(),
                                 updatedObj.getNum_spec(),
                                 updatedObj.getDate_spec(),
                                 updatedObj.getDest(),
                                 updatedObj.getPrice_trans(),
                                 updatedObj.getTel(),
                                 code,
                                 updatedObj.getNum_spec(),updatedObj.getNumReq());
    }

    @Override
    public void delete(String code) {
        jdbcTemplate.update("delete from \"REQ\" where num_req=?", code);
    }

    String backupFile = "req_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"REQ\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"REQ\" *; copy \"REQ\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }
}
