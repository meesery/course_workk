package ru.coursework.bibd.DAO.Otchety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.Models.Otchety.OM;

import java.util.List;

@Component
public class OMDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OMDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OM> report(int month, int year){
        String sql="SELECT code_route,addr_route,probeg,count(*),sum(weight) from \"PL\" WHERE date_part('month', date_start) = ? AND date_part('year', date_start) = ? " +
                "group by code_route,addr_route,probeg";
        return jdbcTemplate.query(sql, new Object[]{month, year}, new OMRowMapper());
    }

}
