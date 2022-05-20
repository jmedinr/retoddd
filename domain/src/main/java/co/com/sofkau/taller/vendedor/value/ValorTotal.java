package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorTotal implements ValueObject<Integer> {
    private final Integer value;
    private final ValorCompra valorCompra;
    private final ValorReparacion valorReparacion;

    public ValorTotal(Integer value, ValorCompra valorCompra, ValorReparacion valorReparacion) {
        this.value = Objects.requireNonNull(value);
        this.valorCompra = Objects.requireNonNull(valorCompra);
        this.valorReparacion = Objects.requireNonNull(valorReparacion);
        if (this.value < 0) {
            throw new IllegalArgumentException("El valor total no puede ser menor que cero");
        }
    }

    @Override
    public Integer value() {
        return valorCompra.value() + valorReparacion.value();
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
