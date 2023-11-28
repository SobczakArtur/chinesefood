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

    public Food getById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM foodmenu WHERE ID=?",
                BeanPropertyRowMapper.newInstance(Food.class), id);
    }

    public int save(List<Food> dishes) {
        dishes.forEach(dish -> jdbcTemplate
                .update("INSERT INTO foodmenu(dish, price) VALUES(?, ?)",
                        dish.getDish(), dish.getPrice()
                ));

        return 1;
    }

    public int update(Food food){
        return jdbcTemplate.update("UPDATE foodmenu SET dish=?, price=? WHERE id=?",
                food.getDish(), food.getPrice(), food.getId());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM foodmenu WHERE id=?",
                id);
    }
}
