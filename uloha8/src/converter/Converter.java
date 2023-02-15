package converter;

/**
 * Basic convert interface
 *
 * @param <T> Resulting format
 * @author Adam Repka
 */
public interface Converter<T> {
    T convert();
}
