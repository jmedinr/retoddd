package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.mecanico.value.ReparacionId;

public class ReparacionAgregada extends DomainEvent {
    private final ReparacionId reparacionId;
    private final Estados estados;
    private final Observacion observacion;

    public ReparacionAgregada(ReparacionId reparacionId, Estados estados, Observacion observacion) {
        super("co.com.sofkau.taller.ReparacionAgregada");
        this.reparacionId = reparacionId;
        this.estados = estados;
        this.observacion = observacion;
    }

    public ReparacionId getReparacionId() {
        return reparacionId;
    }

    public Estados getEstados() {
        return estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
