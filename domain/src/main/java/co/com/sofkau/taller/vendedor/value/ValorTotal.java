package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorTotal implements ValueObject<Integer> {
    private final ValorCompra valorCompra;
    private final ValorReparacion valorReparacion;
    private Integer value;

    public ValorTotal(ValorCompra valorCompra, ValorReparacion valorReparacion) {
        this.value = 0;
        this.valorCompra = Objects.requireNonNull(valorCompra);
        this.valorReparacion = Objects.requireNonNull(valorReparacion);
    }

    @Override
    public Integer value() {
        value = valorCompra.value() + valorReparacion.value();
        if (this.value < 0) {
            throw new IllegalArgumentException("El valor total no puede ser menor que cero");
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValorTotal)) return false;
        ValorTotal that = (ValorTotal) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
