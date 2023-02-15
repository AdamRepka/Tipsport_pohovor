package converter.forrest;

import application.model.Forrest;
import converter.Converter;

/**
 * Converter to the Forrest data object interface
 *
 * @author Adam Repka
 */
public interface ForrestConverterInt extends Converter<Forrest> {
    @Override
    Forrest convert();
}
