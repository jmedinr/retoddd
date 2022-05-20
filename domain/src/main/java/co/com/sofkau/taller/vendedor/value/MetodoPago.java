package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetodoPago implements ValueObject<MetodoPago.Metodo> {
    private final MetodoPago.Metodo value;

    public MetodoPago(MetodoPago.Metodo value) {
        this.value = value;
    }

    @Override
    public MetodoPago.Metodo value() {
        return value;
    }

    public enum Metodo{
        EFECTIVO, TRANSFERENCIA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetodoPago)) return false;
        MetodoPago that = (MetodoPago) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
