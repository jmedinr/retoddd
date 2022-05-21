package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.mecanico.value.GarantiaId;

/**
 * Entidad garantia representa un trabajo de garantia
 */
public class Garantia extends Entity<GarantiaId> {
    protected Estados estados;
    protected Observacion observacion;

    public Garantia(GarantiaId entityId, Estados estados, Observacion observacion) {
        super(entityId);
        this.estados = estados;
        this.observacion = observacion;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }
}
