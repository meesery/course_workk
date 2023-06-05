package ru.coursework.bibd.DAO.Operativnye.PL;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Operativnye.PL;

import java.sql.ResultSet;
import java.sql.SQLException;

class PLRowMapper implements RowMapper<PL>{
    @Override
    public PL mapRow(ResultSet rs, int rowNum) throws SQLException {
        PL pl = new PL();

        pl.setNumPl(rs.getString("num_pl"));
        pl.setDatePl(rs.getDate("date_pl"));
        pl.setFioDriv(rs.getString("fio_driv"));
        pl.setNumAuto(rs.getString("auto_num"));
        pl.setNumLic(rs.getString("drlic_num"));
        pl.setMarkAuto(rs.getString("auto_mark"));
        pl.setDateStart(rs.getDate("date_start"));
        pl.setDateFinish(rs.getDate("date_finish"));
        pl.setAddrRoute(rs.getString("addr_route"));
        pl.setCodeRoute(rs.getString("code_route"));
        pl.setProbeg(rs.getDouble("probeg"));
        pl.setWeight(rs.getDouble("weight"));
        pl.setCodeIzd(rs.getString("code_izd"));
        pl.setPrice(rs.getInt("price"));

        return pl;
    }
}