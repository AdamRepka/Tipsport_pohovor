/**
 * Main class
 *
 * @author Adam Repka
 */
public class Main {
    public static void main(String[] args) {

        CaloriesConverter caloriesConverter = new CaloriesConverter(InputString.input, Separator.DOUBLE_NEWLINE);
        CaloriesCounter caloriesCounter = new CaloriesCounter(caloriesConverter.convert());

        System.out.println(caloriesCounter.findMaxCalories());
        System.out.println(caloriesCounter.findTopThreeSum());
    }
}