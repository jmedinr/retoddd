package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.mecanico.value.GarantiaId;

/**
 * Evento que se lanza cuando una garantia es iniciada
 */
public class GarantiaAgregada extends DomainEvent {
    private final GarantiaId garantiaId;
    private final TipoTrabajo tipoTrabajo;
    private final Estados estados;
    private final Observacion observacion;

    public GarantiaAgregada(GarantiaId garantiaId, TipoTrabajo tipoTrabajo, Estados estados, Observacion observacion) {
        super("co.com.sofkau.taller.GarantiaAgregada");
        this.garantiaId = garantiaId;
        this.tipoTrabajo = tipoTrabajo;
        this.estados = estados;
        this.observacion = observacion;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public GarantiaId getGarantiaId() {
        return garantiaId;
    }

    public Estados getEstados() {
        return estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
