package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estados implements ValueObject<Estados.Estado> {
    private Estados.Estado value;

    public Estados(Estados.Estado value) {
        this.value = value;
    }

    @Override
    public Estados.Estado value() {
        return value;
    }

    public Estados finalizar() {
        return new Estados(Estado.FINALIZADO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estados)) return false;
        Estados estados = (Estados) o;
        return value == estados.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Estado {
        ENPROCESO, FINALIZADO
    }
}
