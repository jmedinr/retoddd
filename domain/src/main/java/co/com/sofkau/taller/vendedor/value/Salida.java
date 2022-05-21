package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Salida implements ValueObject<Salida.Pros> {

    private final LocalDateTime horaSalida;
    private final LocalDate diaSalida;

    public Salida(LocalDateTime hora, LocalDate dia) {
        this.horaSalida = Objects.requireNonNull(hora);
        this.diaSalida = Objects.requireNonNull(dia);
    }

    @Override
    public Salida.Pros value() {
        return new Salida.Pros() {
            @Override
            public LocalDateTime horaSalida() {
                return horaSalida;
            }

            @Override
            public LocalDate diaSalida() {
                return diaSalida;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salida)) return false;
        Salida salida = (Salida) o;
        return Objects.equals(horaSalida, salida.horaSalida) && Objects.equals(diaSalida, salida.diaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaSalida, diaSalida);
    }

    public interface Pros {
        LocalDateTime horaSalida();

        LocalDate diaSalida();
    }
}
