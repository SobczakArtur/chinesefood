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

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Food updatedFood){
        Food food = foodRepository.getById(id);

        if (food != null){
            food.setDish(updatedFood.getDish());
            food.setPrice(updatedFood.getPrice());

            foodRepository.update(food);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int particularyUpdate(@PathVariable("id") int id, @RequestBody Food updatedFood){
        Food food = foodRepository.getById(id);

        if (food != null){
            if (updatedFood.getDish() != null) {
                food.setDish(updatedFood.getDish());
            }
            if (updatedFood.getPrice() > 0) {
                food.setPrice(updatedFood.getPrice());
            }

            foodRepository.update(food);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return foodRepository.delete(id);
    }

}
