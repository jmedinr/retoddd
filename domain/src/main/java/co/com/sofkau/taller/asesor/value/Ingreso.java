package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ingreso implements ValueObject<Ingreso.Pros> {

    private final LocalDateTime horaingreso;
    private final LocalDate diaIngreso;

    public Ingreso(LocalDateTime hora, LocalDate dia) {
        this.horaingreso = Objects.requireNonNull(hora);
        this.diaIngreso = Objects.requireNonNull(dia);
    }

    @Override
    public Pros value() {
        return new Pros() {
            @Override
            public LocalDateTime horaingreso() {
                return horaingreso;
            }

            @Override
            public LocalDate diaIngreso() {
                return diaIngreso;
            }
        };
    }

    public interface Pros {
        LocalDateTime horaingreso();
        LocalDate diaIngreso();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingreso)) return false;
        Ingreso ingreso = (Ingreso) o;
        return Objects.equals(horaingreso, ingreso.horaingreso) && Objects.equals(diaIngreso, ingreso.diaIngreso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaingreso, diaIngreso);
    }
}
