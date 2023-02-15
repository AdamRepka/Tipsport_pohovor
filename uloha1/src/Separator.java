/**
 * Enum for more code reuse and to avoid code smells like hard coded constants
 *
 * @author Adam Repka
 */
public enum Separator {
    DOUBLE_NEWLINE("\\n\\n");

    private final String s;

    Separator(String s) {
        this.s = s;
    }

    /**
     * @return String representation of Enum value
     */
    public String stringValue() {
        return s;
    }
}
