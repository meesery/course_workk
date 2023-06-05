package ru.coursework.bibd.DAO.Spravochniki.SSI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.coursework.bibd.DAO.IDao;
import ru.coursework.bibd.Models.Spravochniki.SSI;

import java.util.List;

@Component
public class SSIDao implements IDao<SSI> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SSIDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<SSI> index() {
            return jdbcTemplate.query("Select * from \"SSI\"", new SSIRowMapper());
        }
    @Override
    public SSI show(String code) {
        return jdbcTemplate.query("Select * from \"SSI\" where code_izd=?", new Object[]{code}, new SSIRowMapper())
                .stream().findAny().orElse(null);
    }

    public SSI search(String codeOrName) {
        return jdbcTemplate.query("Select * from \"SSI\" where code_izd=? OR name_izd=?", new Object[]{codeOrName, codeOrName}, new SSIRowMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(SSI ssi) {
            String sql = "insert into \"SSI\" (code_izd, name_izd, ed_izm, price_izd, weight_izd, volume_izd, kind_izd) values (?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,        ssi.getCodeIzd(),
                                            ssi.getNameIzd(),
                                            ssi.getEdIzm(),
                                            ssi.getPriceIzd(),
                                            ssi.getWeightIzd(),
                                            ssi.getVolumeIzd(),
                                            ssi.getKindIzd());
    }

    @Override
    public void update(String code, SSI updatedSsi) {
        String sql = "update \"SSI\" set code_izd=?, name_izd=?, ed_izm=?, price_izd=?, weight_izd=?, volume_izd=?, kind_izd=? where code_izd=?";
        jdbcTemplate.update(sql, updatedSsi.getCodeIzd(),
                                 updatedSsi.getNameIzd(),
                                 updatedSsi.getEdIzm(),
                                 updatedSsi.getPriceIzd(),
                                 updatedSsi.getWeightIzd(),
                                 updatedSsi.getVolumeIzd(),
                                 updatedSsi.getKindIzd(),
                                 code);
    }

    @Override
    public void delete(String code) {
        String sql = "delete from \"SSI\" where code_izd=?";
        jdbcTemplate.update(sql, code);
    }

    String backupFile = "ssi_backup.csv';";
    public void backup(){
        jdbcTemplate.execute("copy \"SSI\" to"+path+backupFile);
    }

    public void restore(){
        String sql = "delete from \"SSI\" *; copy \"SSI\" from "+path+ backupFile;
        jdbcTemplate.execute(sql);
    }



}
