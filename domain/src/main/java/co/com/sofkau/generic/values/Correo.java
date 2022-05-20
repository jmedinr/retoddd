package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Correo implements ValueObject<String> {
    private final String value;

    public Correo(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El correo no puede estar en blanco");
        }

        if (this.value.length() > 100) {
            throw new IllegalArgumentException("El correo no permite mas de 100 caracteres");
        }

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        Matcher mather = pattern.matcher(value);

        if (!mather.find()) {
            throw new IllegalArgumentException("El email ingresado es inválido.");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
