package ru.coursework.bibd.DAO.Operativnye.REQ;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Operativnye.Req;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReqRowMapper implements RowMapper<Req> {
    @Override
    public Req mapRow(ResultSet rs, int rowNum) throws SQLException {
        Req req = new Req();

        req.setNumReq(rs.getString("num_req"));
        req.setDate_req(rs.getDate("date_req"));
        req.setNum_spec(rs.getInt("num_spec"));
        req.setDate_spec(rs.getDate("date_spec"));
        req.setCode_route(rs.getString("code_route"));
        req.setDest(rs.getString("dest"));
        req.setPrice_trans(rs.getInt("price_trans"));
        req.setTel(rs.getString("tel"));
        req.setCode_izd(rs.getString("code_izd"));

        return req;
    }
}
