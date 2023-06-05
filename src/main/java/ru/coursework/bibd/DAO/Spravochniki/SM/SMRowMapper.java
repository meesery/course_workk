package ru.coursework.bibd.DAO.Spravochniki.SM;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Spravochniki.SM;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SMRowMapper implements RowMapper<SM> {
    @Override
    public SM mapRow(ResultSet rs, int rowNum) throws SQLException {
        SM sm = new SM();

        sm.setCodeRoute(rs.getString("code_route"));
        sm.setAddrRoute(rs.getString("addr_route"));
        sm.setLenRoute(rs.getDouble("len_route"));

        return sm;
    }
}
