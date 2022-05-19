package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

public class TipoRegistro implements ValueObject<TipoRegistro.Tipos> {

    private final Tipos value;

    public TipoRegistro(Tipos value) {
        this.value = value;
    }

    @Override
    public Tipos value() {
        return value;
    }

    public enum Tipos{
        REPARACION, GARANTIA
    }
}
