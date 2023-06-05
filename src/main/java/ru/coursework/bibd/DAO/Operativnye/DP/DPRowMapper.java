package ru.coursework.bibd.DAO.Operativnye.DP;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Operativnye.DP;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DPRowMapper implements RowMapper<DP> {
    @Override
    public DP mapRow(ResultSet rs, int rowNum) throws SQLException {
        DP dp = new DP();
        dp.setNumPlan(rs.getString("num_plan"));
        dp.setDatePlan(rs.getDate("date_plan"));
        dp.setNumReq(rs.getString("num_req"));
        dp.setDateReq(rs.getDate("date_req"));
        dp.setCodeIzd(rs.getString("code_izd"));
        dp.setCodeRoute(rs.getString("code_route"));
        dp.setTabNum(rs.getString("tab_num"));
        dp.setDateStart(rs.getDate("date_start"));
        dp.setDateFinish(rs.getDate("date_finish"));
        return dp;
    }
}
