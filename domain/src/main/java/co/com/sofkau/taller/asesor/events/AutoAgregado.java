package co.com.sofkau.taller.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.asesor.value.AutoId;
import co.com.sofkau.taller.asesor.value.Marca;
import co.com.sofkau.taller.asesor.value.Placa;

/**
 * Esta clase es un evento de dominio que se lanza cuando se registra un auto
 */
public class AutoAgregado extends DomainEvent {
    private final AutoId autoId;
    private final Marca marca;
    private final Placa placa;

    public AutoAgregado(AutoId autoId, Marca marca, Placa placa) {
        super("co.com.sofkau.taller.AutoAgregado");
        this.autoId = autoId;
        this.marca = marca;
        this.placa = placa;
    }

    public AutoId getAutoId() {
        return autoId;
    }

    public Marca getMarca() {
        return marca;
    }

    public Placa getPlaca() {
        return placa;
    }
}
