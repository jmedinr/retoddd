package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Esta clase es para la placa del carro a reparar
 */
public class Placa implements ValueObject<String> {
    private final String value;

    public Placa(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La placa no puede estar en blanco");
        }

        if (this.value.length() > 6) {
            throw new IllegalArgumentException("La placa no permite mas de 6 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Placa)) return false;
        Placa placa = (Placa) o;
        return Objects.equals(value, placa.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
