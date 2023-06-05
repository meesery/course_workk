package ru.coursework.bibd.DAO.Operativnye.SPEC;

import org.springframework.jdbc.core.RowMapper;
import ru.coursework.bibd.Models.Operativnye.Spec;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SPECRowMapper implements RowMapper<Spec> {
    @Override
    public Spec mapRow(ResultSet rs, int rowNum) throws SQLException {
        Spec spec = new Spec();
        spec.setNumSpec(rs.getInt("num_spec"));
        spec.setDateSpec(rs.getDate("date_spec"));
        spec.setCodeIzd(rs.getString("code_izd"));
        spec.setNameIzd(rs.getString("name_izd"));
        spec.setEdIzm(rs.getString("ed_izm"));
        spec.setWeightIzd(rs.getDouble("weight_izd"));
        spec.setVolumeIzd(rs.getDouble("volume_izd"));
        spec.setPriceIzd(rs.getInt("price_izd"));
        spec.setAmount(rs.getInt("amount"));
        spec.setCodeRoute(rs.getString("code_route"));
        spec.setFullPrice(rs.getInt("price_full"));
        return spec;
    }
}
