package pl.SobczakArtur.chinesefood;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private int id;
    private String dish;
    private int price;
}
