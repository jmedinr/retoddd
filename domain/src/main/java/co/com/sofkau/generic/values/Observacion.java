package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Observacion es un objeto de valor generico en el cual se describe las reparaciones y garantias
 * realizadas por parte de los mecanicos.
 */
public class Observacion implements ValueObject<String> {

    private final String value;

    public Observacion(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La Observacion no puede estar en blanco");
        }

        if (this.value.length() > 500) {
            throw new IllegalArgumentException("El Observacion no permite mas de 500 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
