import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to convert string input to number of calories carried by each elf
 *
 * @author Adam Repka
 */
public class CaloriesConverter {

    private final String caloriesInput;
    private final Separator regex;

    public CaloriesConverter(String caloriesInput, Separator regex) {
        this.caloriesInput = caloriesInput;
        this.regex = regex;
    }

    /**
     * Converts String to List of Integer values representing calories carried by each elf
     *
     * @return int sum of calories carried by each elf
     */
    public List<Integer> convert() {
        return Arrays.stream(caloriesInput.split(regex.stringValue()))
                .map(x -> x.lines()
                        .mapToInt(Integer::parseInt)
                        .sum())
                .collect(Collectors.toList());
    }
}
