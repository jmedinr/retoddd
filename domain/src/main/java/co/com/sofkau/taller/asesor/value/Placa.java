package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Placa implements ValueObject<String> {
    private final String value;

    public Placa(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La placa no puede estar en blanco");
        }

        if(this.value.length() > 6){
            throw new IllegalArgumentException("La placa no permite mas de 6 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}