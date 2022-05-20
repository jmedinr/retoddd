package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoPago implements ValueObject<TipoPago.Pago> {
    private final TipoPago.Pago value;

    public TipoPago(TipoPago.Pago value) {
        this.value = value;
    }

    @Override
    public TipoPago.Pago value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPago)) return false;
        TipoPago tipoPago = (TipoPago) o;
        return value == tipoPago.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Pago {
        CREDITO, CONTADO
    }
}
