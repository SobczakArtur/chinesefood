package pl.SobczakArtur.chinesefood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @GetMapping("/test")
    public String test(){
        return "Działa";
    }

    @GetMapping("/dishes")
    public List<Food> getAll(){
        return foodRepository.getAll();
    }
}
