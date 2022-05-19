package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.ValueObject;

public class AutorizacionCliente implements ValueObject<AutorizacionCliente.Autorizacion> {
    private final AutorizacionCliente.Autorizacion value;

    public AutorizacionCliente(Autorizacion value) {
        this.value = value;
    }

    @Override
    public Autorizacion value() {
        return value;
    }

    public enum Autorizacion{
        AUTORIZADO, NOAUTORIZADO
    }
}
