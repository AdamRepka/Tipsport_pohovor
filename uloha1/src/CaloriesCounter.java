import java.util.Comparator;
import java.util.List;

/**
 * Class for counting calories carried by each elf
 *
 * @author Adam Repka
 */
public class CaloriesCounter {

    private final List<Integer> caloriesList;

    public CaloriesCounter(List<Integer> caloriesList) {
        this.caloriesList = caloriesList;
    }

    /**
     * Finds max calories carried by a single elf
     *
     * @return int max calories carried by a single elf
     */
    public int findMaxCalories() {
        return caloriesList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    /**
     * Finds sum of top three elves by calories carried
     *
     * @return int sum of top three elves by calories carried
     */
    public int findTopThreeSum() {
        return caloriesList.stream()
                .mapToInt(Integer::intValue)
                .boxed()
                .sorted(Comparator.reverseOrder()) // Descending sort
                .mapToInt(Integer::intValue)
                .limit(3) // Top three
                .sum();
    }
}
