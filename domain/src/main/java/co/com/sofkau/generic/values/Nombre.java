package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Nombre es un objeto de valor generico para los telefonos de los vendedores, asesores, mecanicos y clientes
 */
public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }

        if (this.value.length() > 50) {
            throw new IllegalArgumentException("El nombre no permite mas de 50 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
