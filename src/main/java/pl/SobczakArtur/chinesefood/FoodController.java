package pl.SobczakArtur.chinesefood;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @GetMapping("/test")
    public String test(){
        return "Działa";
    }
}
