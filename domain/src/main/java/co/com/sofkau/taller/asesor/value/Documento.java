package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Documento implements ValueObject<String> {
    private final String value;

    public Documento(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El documento no puede estar en blanco");
        }

        if(this.value.length() > 20){
            throw new IllegalArgumentException("El documento no permite mas de 20 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
