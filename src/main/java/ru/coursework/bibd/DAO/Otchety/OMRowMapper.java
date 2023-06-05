package ru.coursework.bibd.DAO.Otchety;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Otchety.OM;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OMRowMapper implements RowMapper<OM> {
    @Override
    public OM mapRow(ResultSet rs, int rowNum) throws SQLException {
       OM om = new OM();
       om.setCode(rs.getString("code_route"));
       om.setAddr(rs.getString("addr_route"));
       om.setProbeg(rs.getDouble("probeg"));
       om.setCount(rs.getInt("count"));
       om.setSum(rs.getInt("sum"));
        return om;
    }
}
