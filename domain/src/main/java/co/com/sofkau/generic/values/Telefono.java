package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar en blanco");
        }

        if (this.value.length() > 10) {
            throw new IllegalArgumentException("El teléfono no permite mas de 10 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
