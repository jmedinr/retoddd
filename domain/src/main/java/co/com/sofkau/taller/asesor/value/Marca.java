package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<String> {
    private final String value;

    public Marca(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La marca no puede estar en blanco");
        }

        if(this.value.length() > 50){
            throw new IllegalArgumentException("La marca no permite mas de 50 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
