package co.com.sofkau.taller.mecanico.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diagnostico implements ValueObject<String> {
    private final String value;

    public Diagnostico(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El diagnostico no puede estar en blanco");
        }

        if (this.value.length() > 500) {
            throw new IllegalArgumentException("El diagnostico no permite mas de 500 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnostico)) return false;
        Diagnostico that = (Diagnostico) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
