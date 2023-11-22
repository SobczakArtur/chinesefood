package pl.SobczakArtur.chinesefood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Food> getAll(){
        return jdbcTemplate.query("SELECT * FROM foodmenu",
                BeanPropertyRowMapper.newInstance(Food.class));
    }

}
