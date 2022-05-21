package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosAuto implements ValueObject<DatosAuto.Value> {

    private final String marca;
    private final String placa;

    public DatosAuto(String marca, String placa) {
        this.marca = Objects.requireNonNull(marca);
        this.placa = Objects.requireNonNull(placa);

        if (this.marca.isBlank()) {
            throw new IllegalArgumentException("El marca del carro no puede estar en blanco");
        }

        if (this.marca.length() > 50) {
            throw new IllegalArgumentException("La Marca del carro no permite mas de 50 caracteres");
        }

        if (this.placa.isBlank()) {
            throw new IllegalArgumentException("La placa no puede estar en blanco");
        }

        if (this.placa.length() > 6) {
            throw new IllegalArgumentException("La placa no permite mas de 6 caracteres");
        }
    }

    @Override
    public DatosAuto.Value value() {
        return new DatosAuto.Value() {
            @Override
            public String marca() {
                return marca;
            }

            @Override
            public String placa() {
                return placa;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosAuto)) return false;
        DatosAuto datosAuto = (DatosAuto) o;
        return Objects.equals(marca, datosAuto.marca) && Objects.equals(placa, datosAuto.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, placa);
    }

    public interface Value {
        String marca();

        String placa();
    }
}
