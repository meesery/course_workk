package ru.coursework.bibd.DAO.Spravochniki.SA;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Spravochniki.SA;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SARowMapper implements RowMapper<SA> {
    @Override
    public SA mapRow(ResultSet rs, int rowNum) throws SQLException {
        SA sa = new SA();
        sa.setAutoNum(rs.getString("auto_num"));
        sa.setAutoMark(rs.getString("auto_mark"));
        sa.setLoadCap(rs.getInt("load_cap"));
        sa.setYearProd(rs.getInt("year_prod"));
        sa.setFirstCost(rs.getDouble("first_cost"));
        sa.setCodeAm(rs.getString("code_am"));
        sa.setPercAm(rs.getDouble("perc_am"));
        sa.setSrokIsp(rs.getInt("srok_isp"));
        sa.setLastCost(rs.getDouble("last_cost"));
        return sa;
    }
}
