package ru.coursework.bibd.DAO.Spravochniki.SSI;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Spravochniki.SSI;


import java.sql.ResultSet;
import java.sql.SQLException;

public class SSIRowMapper implements RowMapper<SSI> {
    @Override
    public SSI mapRow(ResultSet rs, int rowNum) throws SQLException {
        SSI ssi = new SSI();

        ssi.setCodeIzd(rs.getString("code_izd"));
        ssi.setNameIzd(rs.getString("name_izd"));
        ssi.setEdIzm(rs.getString("ed_izm"));
        ssi.setPriceIzd(rs.getInt("price_izd"));
        ssi.setWeightIzd(rs.getDouble("weight_izd"));
        ssi.setVolumeIzd(rs.getDouble("volume_izd"));
        ssi.setKindIzd(rs.getString("kind_izd"));

        return ssi;
    }
}
