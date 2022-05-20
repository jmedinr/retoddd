package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosCliente implements ValueObject<String> {

    private final String nombre;

    public DatosCliente(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar en blanco");
        }

        if (this.nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre no permite mas de 50 caracteres");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}
