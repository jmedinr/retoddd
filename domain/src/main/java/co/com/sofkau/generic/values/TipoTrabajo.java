package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Esta clase es un objeto de valor que describe el tipo de trabajo que realizará el mecanico
 */
public class TipoTrabajo implements ValueObject<TipoTrabajo.Tipos> {

    private final TipoTrabajo.Tipos value;

    public TipoTrabajo(TipoTrabajo.Tipos value) {
        this.value = value;
    }

    @Override
    public TipoTrabajo.Tipos value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoTrabajo)) return false;
        TipoTrabajo that = (TipoTrabajo) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Tipos {
        REPARACION, GARANTIA
    }
}
