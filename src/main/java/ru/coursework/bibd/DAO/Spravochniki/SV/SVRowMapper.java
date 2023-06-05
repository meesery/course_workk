package ru.coursework.bibd.DAO.Spravochniki.SV;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Spravochniki.SV;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SVRowMapper implements RowMapper<SV> {
    @Override
    public SV mapRow(ResultSet rs, int rowNum) throws SQLException {
        SV sv = new SV();
        sv.setTabNum(rs.getString("tab_num"));
        sv.setFio(rs.getString("fio_driv"));
        sv.setDateOfBirth(rs.getDate("date_birth"));
        sv.setDateOfDrLic(rs.getDate("drlic_date"));
        sv.setDateOfValid(rs.getDate("valid_date"));
        sv.setPassNum(rs.getString("passport_num"));
        sv.setDriverCat(rs.getString("drlic_cat"));
        sv.setLicNum(rs.getString("drlic_num"));
        return sv;
    }
}
