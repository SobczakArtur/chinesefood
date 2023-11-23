package pl.SobczakArtur.chinesefood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dishes")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @GetMapping("")
    public List<Food> getAll(){
        return foodRepository.getAll();
    }

    @GetMapping("/{id}")
    public Food getById(@PathVariable("id") int id){
        return foodRepository.getById(id);
    }

    @PostMapping("")
    public int addDish (@RequestBody List <Food> dishes){
        return foodRepository.save(dishes);
    }

}
