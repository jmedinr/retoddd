package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Esta clase es un objeto de valor para registrar que un cliente autoriza que se le repare el auto.
 */
public class AutorizacionCliente implements ValueObject<AutorizacionCliente.Autorizacion> {
    private final AutorizacionCliente.Autorizacion value;

    public AutorizacionCliente(Autorizacion value) {
        this.value = value;
    }

    @Override
    public Autorizacion value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutorizacionCliente)) return false;
        AutorizacionCliente that = (AutorizacionCliente) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Autorizacion {
        AUTORIZADO, NOAUTORIZADO
    }
}
