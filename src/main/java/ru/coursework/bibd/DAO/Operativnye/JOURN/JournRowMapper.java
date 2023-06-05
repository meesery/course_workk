package ru.coursework.bibd.DAO.Operativnye.JOURN;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Operativnye.Journ;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournRowMapper implements RowMapper<Journ> {
    @Override
    public Journ mapRow(ResultSet rs, int rowNum) throws SQLException {
        Journ journ = new Journ();
        journ.setNumReq(rs.getString("num_req"));
        journ.setDateReq(rs.getDate("date_req"));
        journ.setDatePlanl(rs.getDate("date_plan"));
        journ.setTel(rs.getString("tel"));
        return journ;
    }
}
